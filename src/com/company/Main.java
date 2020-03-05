package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashTable hashTable = new HashTable();

        hashTable.add("toto");
        hashTable.add("otot");
        hashTable.add("titi");
        hashTable.add("tata");

        System.out.println(hashTable.search("tototiti"));
    }
}





