package Containers;

import Condiment.CondimentGeneral;
import Flavor.FlavorGeneral;

import java.util.ArrayList;

public class Cup{
    public Cup(){}
    //Substances
    ArrayList<FlavorGeneral> flavorsParticles = new ArrayList<>();
    ArrayList<CondimentGeneral> condimentParticles = new ArrayList<>();
    public boolean recieveFlavor(FlavorGeneral FG){
        if(FG != null){
            System.out.print("\n"+FG.getFlavorName());
            flavorsParticles.add(FG);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<String> peakParticles(){
        ArrayList<String> nameofParticles = new ArrayList<>();
        for(FlavorGeneral flavor : flavorsParticles) nameofParticles.add(flavor.getFlavorName());
        for(CondimentGeneral condiment : condimentParticles) nameofParticles.add(condiment.getCondimentName());
        return nameofParticles;
    }

    public boolean recieveCondiment(CondimentGeneral CG){
        if(CG != null){
            System.out.print("\n"+CG.getCondimentName());
            condimentParticles.add(CG);
            return true;
        }else {
            return false;
        }
    }
}
