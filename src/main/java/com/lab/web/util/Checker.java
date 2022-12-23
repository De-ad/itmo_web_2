package com.lab.web.util;

public class Checker {

    public String check(double x, double y, double r){
        if (checkSquare(x, y, r) || checkCircle(x, y, r) || checkTriangle(x, y, r)){
            return "true";
        }
        return "false";
    }

    public boolean checkCircle(double x, double y, double r ){
        return ((x<=0) && (y<=0) && (Math.pow(r, 2) >= Math.pow(y, 2) + Math.pow(x, 2)));
    }

    public boolean checkTriangle(double x, double y, double r){
        return ((x <=0) && (y>=0) && (y-x <=r) );
    }

    public boolean checkSquare(double x, double y, double r){
        return ((x>=0) && (y<=0) && (x<= (r/2)) && (y >= (-r)));
    }

}
