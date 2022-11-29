package com.lab.web.util;

import com.lab.web.DTO.Coordinates;
import com.lab.web.DTO.HitRow;
import org.kopitubruk.util.json.JSONUtil;

import java.util.ArrayList;

public class HitRowFormatter {

    public static String getRows(ArrayList<HitRow> str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.size(); i++) {
                stringBuilder.append("<tr>")
                        .append("<th>").append(str.get(i).getX()).append("</th>")
                        .append("<th>").append(str.get(i).getY()).append("</th>")
                        .append("<th>").append(str.get(i).getR()).append("</th>")
                        .append("<th>").append(str.get(i).getResult()).append("</th>")
                        .append("<th>").append(str.get(i).getCurrentTime()).append("</th>")
                        .append("<th>").append(str.get(i).getExecutionTime()).append("</th>")
                        .append("</tr>");
            }
            return stringBuilder.toString();
        } catch (Exception e){
            return "";
        }
    }

    public static String getDots(ArrayList<HitRow> str){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> coords = new ArrayList<>();
            for (int i = 0; i < str.size(); i++) {
                Coordinates coordinates = new Coordinates(str.get(i).getX(), str.get(i).getY(), str.get(i).getR());
                coords.add(coordinates.convertToJson());
            }

            return coords.toString();

        } catch (Exception e){
            return "";
        }
    }

}
