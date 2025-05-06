package ru.otus.java.basic.homeworks.homework32.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework32.HttpRequest;
import ru.otus.java.basic.homeworks.homework32.application.Item;
import ru.otus.java.basic.homeworks.homework32.application.ItemRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ItemProcessor implements RequestProcessor {
    private ItemRepository itemRepository;

    public ItemProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(HttpRequest request, OutputStream out) throws IOException {

        if (request.getParameter("id") != null) {
            Long id = Long.parseLong(request.getParameter("id"));
            Item item = itemRepository.findById(id);
            if(item==null){
                Gson gson = new Gson();
                String itemResponse = gson.toJson(item);
                String respose = "" +
                        "HTTP/1.1 404 Not Found\r\n" +
                        "Content-type: text/html\r\n" +
                        "\r\n" +
                        "RESOURCE NOT FOUND";
                out.write(respose.getBytes(StandardCharsets.UTF_8));
                return;
            }
            Gson gson = new Gson();
            String itemResponse = gson.toJson(item);
            String respose = "" +
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-type: application/json\r\n" +
                    "\r\n" +
                    itemResponse;
            out.write(respose.getBytes(StandardCharsets.UTF_8));
            return;
        }
        List<Item> allItems = itemRepository.getAllItems();
        Gson gson = new Gson();
        String itemResponse = gson.toJson(allItems);
        String respose = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-type: application/json\r\n" +
                "\r\n" +
                itemResponse;
        out.write(respose.getBytes(StandardCharsets.UTF_8));
    }
}
