package Flavor;

public abstract class FlavorGeneral {
    String name="N/A";
    public FlavorGeneral(){
        this.name = name;
    }
    public FlavorGeneral(String name){
        this.name = name;
    }
    public String getFlavorName(){
        return this.name;
    }


}
