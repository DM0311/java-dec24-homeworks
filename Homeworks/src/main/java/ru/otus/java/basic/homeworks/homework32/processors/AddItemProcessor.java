package ru.otus.java.basic.homeworks.homework32.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework32.HttpRequest;
import ru.otus.java.basic.homeworks.homework32.application.Item;
import ru.otus.java.basic.homeworks.homework32.application.ItemRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class AddItemProcessor implements RequestProcessor {
    private ItemRepository itemRepository;

    public AddItemProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(HttpRequest request, OutputStream out) throws IOException {
        Gson gson = new Gson();
        Item item = gson.fromJson(request.getBody(), Item.class);
        itemRepository.addNewItem(item);
        String respose = "" +
                "HTTP/1.1 201 Created\r\n" +
                "Content-type: application/json\r\n" +
                "\r\n";
        out.write(respose.getBytes(StandardCharsets.UTF_8));
    }
}
