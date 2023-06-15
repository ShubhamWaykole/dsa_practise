package DesignPatterns.Creational;

import lombok.Getter;
import lombok.Setter;

public class BuilderDesignPattern {

    public static void main(String[] args) {
        House h1 = new House.HouseBuilder(1,1).setType().build();
        System.out.println("House h1 is a " + h1.getType());
        House h2 = new House.HouseBuilder(6,3).setType().build();
        System.out.println("House h2 is a " + h2.getType());
        House h3 = new House.HouseBuilder(3,1).setType().build();
        System.out.println("House h3 is a " + h3.getType());
    }

}

class House {
    int rooms;
    String type;
    int floors;

    public House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.type = builder.type;
        this.floors = builder.floors;
    }

    public String getType() {
        return this.type;
    }

    @Getter
    @Setter
    public static class HouseBuilder {
        private int rooms;
        private String type;
        private int floors;
        public HouseBuilder(int rooms, int floors) {
            this.floors = floors;
            this.rooms = rooms;
        }

        public HouseBuilder setType() {
            if(rooms <= 2)
                this.type =  "SMALL_HOUSE";
            else if(rooms > 2 && floors == 1)
                this.type =  "BIG_HOUSE";
            else if(rooms > 2 && floors == 2)
                this.type =  "BUNGALOW";
            else if(floors > 2)
                this.type =  "APARTMENT";
            else this.type =  null;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }


}
