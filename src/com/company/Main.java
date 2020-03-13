package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Tepenox\\IdeaProjects\\tp2-algo1-l2\\src\\com\\company\\dico.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        HashTable hashTable = new HashTable();

        String st;
        while ((st = br.readLine()) != null){
            hashTable.add(st);
        }
//        hashTable.add("toto");
//        hashTable.add("otot");
//        hashTable.add("titi");
//        hashTable.add("tata");
        System.out.println(hashTable.search("AhDelhi"));
    }
}





