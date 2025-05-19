package ru.otus.java.basic.homeworks.homework32;

import ru.otus.java.basic.homeworks.homework32.application.ItemRepository;
import ru.otus.java.basic.homeworks.homework32.processors.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private Map<String, RequestProcessor> processors;
    private RequestProcessor defaultProcessor;
    private ItemRepository itemRepository;

    public Dispatcher() {
        this.processors = new HashMap<>();
        this.itemRepository = new ItemRepository();
        this.processors.put("GET /hello", new HelloProcessor());
        this.processors.put("GET /calculator", new CalculatorProcessor());
        this.processors.put("GET /items", new GetItemProcessor(itemRepository));
        this.processors.put("POST /items", new AddItemProcessor(itemRepository));
        this.defaultProcessor = new DefaultProcessor();

    }

    public void execute(HttpRequest request, OutputStream out) throws IOException{
        if (!processors.containsKey(request.getRoutingKey())) {
            defaultProcessor.execute(request, out);
            return;
        }
        processors.get(request.getRoutingKey()).execute(request,out);
    }
}
