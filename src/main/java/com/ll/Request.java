package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> paramMap;

    public Request(String input) {
        String[] inputs = input.split("\\?");
        actionCode = inputs[0];

        if (inputs.length > 1) {
            paramMap = new HashMap<>();
            String[] params = inputs[1].split("&");

            for (String param : params) {
                String[] str = param.split("=");
                paramMap.put(str[0], str[1]);
            }
        }
    }


    public String getActionCode() {
        return actionCode;
    }

    public Map<String, String> getParamMap() {
        return paramMap;
    }
}
