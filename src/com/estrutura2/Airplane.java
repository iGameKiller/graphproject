package com.estrutura2;

public class Airplane {

    public String abv;
    public String capacity;

    public Airplane(String abv, String capacity) {
        this.abv = abv;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "abv='" + abv + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
