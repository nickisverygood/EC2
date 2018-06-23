package Machines;

import java.util.ArrayList;
import java.util.List;

public class Dispenser<T> {
    private List<T> items ; // represents the list of items of type we will pass

    public Dispenser(List<T> items){
        this.items = items;
    }

    public List<T> DispenseBeverage(){
        return items;
    }

    public T dispense(){
        // write code to issue item.
        if(items.size()>0){
            T firstItem = items.get(0);
            items.remove(0);
            return firstItem;
        }else {
            return null;
        }

    }

    public void load(T item){ // again pass the same "T" type to issueItem method
        items.add(item);
    }
}


