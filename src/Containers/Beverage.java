package Containers;

import Condiment.CondimentGeneral;
import Condiment.Cream;
import Condiment.Splenda;
import Condiment.Sugar;
import Flavor.Chocolate.HotChocolate;
import Flavor.Coffee.DeCafPikePlace;
import Flavor.Coffee.PikePlace;
import Flavor.Coffee.Verona;
import Flavor.FlavorGeneral;
import Flavor.Water.HotWater;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Beverage {

    //Properties
    Set<String> flavors = new HashSet<>();
    Set<String> condiments = new HashSet<>();
    String size;

    //Substances
    ArrayList<FlavorGeneral> flavorsParticles = new ArrayList<>();
    ArrayList<CondimentGeneral> condimentParticles = new ArrayList<>();

    public ArrayList<FlavorGeneral> getFlavorsParticles() {
        int amountOfEach = 0;
        if (flavors.size() > 0) {
            switch (size) {
                case "Large":
                    amountOfEach = 100 / flavors.size();
                case "Medium":
                    amountOfEach = 80 / flavors.size();
                case "Small":
                    amountOfEach = 60 / flavors.size();
            }
            for (String flavor : flavors) {
                switch (flavor) {
                    case "HotChocolate":
                        for (int i = 0; i < amountOfEach; i++) flavorsParticles.add(new HotChocolate());
                        break;
                    case "DeCafPikePlace":
                        for (int i = 0; i < amountOfEach; i++) flavorsParticles.add(new DeCafPikePlace());
                        break;
                    case "PikePlace":
                        for (int i = 0; i < amountOfEach; i++) flavorsParticles.add(new PikePlace());
                        break;
                    case "Verona":
                        for (int i = 0; i < amountOfEach; i++) flavorsParticles.add(new Verona());
                        break;
                    case "HotWater":
                        for (int i = 0; i < amountOfEach; i++) flavorsParticles.add(new HotWater());
                        break;
                }
            }
        }
        return flavorsParticles;
    }

    public ArrayList<CondimentGeneral> getCondimentParticles() {
        int amountOfEach = 0;
        if (condiments.size() > 0) {
            switch (size) {
                case "Large":
                    amountOfEach = 5;
                case "Medium":
                    amountOfEach = 4;
                case "Small":
                    amountOfEach = 3;
            }
            for (String condiment : condiments) {
                switch (condiment) {
                    case "Cream":
                        for (int i = 0; i < amountOfEach; i++) condimentParticles.add(new Cream());
                    case "Splenda":
                        for (int i = 0; i < amountOfEach; i++) condimentParticles.add(new Splenda());
                    case "Sugar":
                        for (int i = 0; i < amountOfEach; i++) condimentParticles.add(new Sugar());
                }
            }
        }
        return condimentParticles;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public void addCondiments(String condiment) {
        this.condiments.add(condiment);
    }

    public Beverage() {
    }

    public Beverage(String flavor) {
        this.flavors.add(flavor);
    }

    public Beverage(List<String> flavors) {
        for (String flavor : flavors) this.flavors.add(flavor);
    }

    public Set<String> getFlavors() {
        return flavors;
    }

}

