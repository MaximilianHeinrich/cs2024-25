package dev.maximilian;

public class Main {

    public static void main(String[] args) {

        Knoten knoten = new Knoten("Ficken");
        System.out.println(knoten.getName());
        knoten.setName("Ficken2");
        System.out.println(knoten.getName());

    }

}