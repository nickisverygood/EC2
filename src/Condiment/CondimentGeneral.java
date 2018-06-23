package Condiment;

import java.util.ArrayList;

public abstract class CondimentGeneral {
    String name = "Nothing";
    double particalAmount;
    public CondimentGeneral(String name){
        this.name = name;
    }
    public CondimentGeneral(){
        this.name = name;
    }
    public String getCondimentName(){
        return name;
    }
}
