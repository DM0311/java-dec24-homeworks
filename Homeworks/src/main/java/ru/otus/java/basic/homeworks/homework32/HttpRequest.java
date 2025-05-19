package ru.otus.java.basic.homeworks.homework32;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String rawRequest;
    private HttpMethod method;
    private Map<String, String> parameters;
    private String uri;
    private String body;
    private final Logger logger;


    public HttpRequest(String rawRequest) {
        this.rawRequest = rawRequest;
        this.parameters = new HashMap<>();
        this.logger = LogManager.getLogger(HttpRequest.class);
        this.parse();
    }

    private void parse() {
        int startIndex = rawRequest.indexOf(' ');
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        this.method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        if (uri.contains("?")) {
            String[] elements = uri.split("[?]");
            uri = elements[0];
            String[] keysValues = elements[1].split("[&]");
            for (String o : keysValues) {
                String[] keyVal = o.split("=");
                parameters.put(keyVal[0], keyVal[1]);
            }
        }

        if (method == HttpMethod.POST) {
            this.body = rawRequest.substring(rawRequest.indexOf("\r\n\r\n"));
        }
    }

    public void info(boolean shawRawRequest) {
        if (shawRawRequest) {
            System.out.println(rawRequest);
        }
        logger.info("METHOD: " + method);
        logger.info("URI: " + uri);
        logger.info("PARAMETERS: " + parameters);
    }

    public String getUri() {
        return uri;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

    public String getRoutingKey() {
        return method + " " + uri;
    }

    public String getBody() {
        return body;
    }
}
