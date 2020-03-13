package com.company;

import java.util.*;

public class HashTable {

    HashMap<List<Character>, List<String>> hashMap = new HashMap();


    public void add (String string){
      List<Character> key =  stringToSortedArray(string);

      if (hashMap.containsKey(key)){
          hashMap.get(key).add(string);
      }else{
          hashMap.put(key,new LinkedList<>(Collections.singletonList(string)));
      }
    }

    public HashMap<List<Character>, List<String>> getHashMap() {
        return hashMap;
    }

    public boolean contains(List<Character> key ){
        return hashMap.containsKey(key);
    }


    public List<String> search(String word){
        for (int i = 1 ; i < word.length() ; i++ ){
            List<Character> list1 = stringToSortedArray(word.substring(0,i));
            if (contains(list1)){
                List<Character> list2 = stringToSortedArray(word.substring(i));
                if (contains(list2)){
                    for (String s1 : hashMap.get(list1)){
                        for (String s2 : hashMap.get(list2)) {
                            String tmpS1 = new String(s1);
                            String tmpS2 = new String(s2);
                            if ((tmpS1 += tmpS2).equals(word) || (tmpS2 += tmpS1).equals(word))
                                return List.of(s1,s2);
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public List<Character> stringToSortedArray(String word){
        char c[] = word.toCharArray();
        List<Character> key =  new ArrayList<>();
        for (Character character: c ){
            key.add(character);
        }
        Collections.sort(key);
        return key;
    }
}
