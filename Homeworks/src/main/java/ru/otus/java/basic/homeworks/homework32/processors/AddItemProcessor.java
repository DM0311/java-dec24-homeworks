package ru.otus.java.basic.homeworks.homework32.processors;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.homeworks.homework32.HttpRequest;
import ru.otus.java.basic.homeworks.homework32.application.Item;
import ru.otus.java.basic.homeworks.homework32.application.ItemRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class AddItemProcessor implements RequestProcessor {
    private ItemRepository itemRepository;
    private final Logger logger;

    public AddItemProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.logger = LogManager.getLogger(AddItemProcessor.class);
    }

    @Override
    public void execute(HttpRequest request, OutputStream out) throws IOException {

        try{
            Gson gson = new Gson();
            Item item = gson.fromJson(request.getBody(), Item.class);
            if(item.getTitle().isEmpty()||(item.getPrice().compareTo(new BigDecimal(0))<0)){
                String respose = "" +
                        "HTTP/1.1 400 Bad Request\r\n" +
                        "Content-type: text/html\r\n" +
                        "\r\n"+
                        "<html><body><h1>Item has no title or price is negative</h1></body></html>";
                out.write(respose.getBytes(StandardCharsets.UTF_8));
                return;
            }
            itemRepository.addNewItem(item);
            String respose = "" +
                    "HTTP/1.1 201 Created\r\n" +
                    "Content-type: application/json\r\n" +
                    "\r\n";
            out.write(respose.getBytes(StandardCharsets.UTF_8));
        }catch (RuntimeException e){
            String respose = "" +
                    "HTTP/1.1 500 Internal Error\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n";
            out.write(respose.getBytes(StandardCharsets.UTF_8));
        }
    }
}
