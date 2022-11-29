package com.lab.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kopitubruk.util.json.JSONUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HitRow {
    private int x;
    private  double y;
    private  double r;
    private String result;
    private LocalDateTime currentTime;
    private double executionTime;

    public String convertToJson(){
        return JSONUtil.toJSON(this.getMap());
    }

    private Map<String, String> getMap(){
        Map<String, String> fields = new HashMap<>();
        fields.put("x", String.valueOf(x));
        fields.put("y", String.valueOf(y));
        fields.put("r", String.valueOf(r));
        fields.put("result", result);
        fields.put("currentTime", String.valueOf(currentTime));
        fields.put("executionTime", String.valueOf(executionTime));
        return fields;
    }

}
