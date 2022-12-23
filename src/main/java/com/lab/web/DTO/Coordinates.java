package com.lab.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.kopitubruk.util.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
public class Coordinates {
    private double x;
    private double y;
    private double r;

    public String convertToJson(){
        return JSONUtil.toJSON(this.getMap());
    }

    private Map<String, String> getMap(){
        Map<String, String> fields = new HashMap<>();
        fields.put("x", String.valueOf(x));
        fields.put("y", String.valueOf(y));
        fields.put("r", String.valueOf(r));
        return fields;
    }

}
