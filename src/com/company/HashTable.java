package com.company;

import java.util.*;

public class HashTable {

    HashMap<List<Character>, List<String>> hashMap = new HashMap();


    public void add (String string){
      char c[] = string.toCharArray();
      List<Character> key =  new ArrayList<>();
      for (Character character: c ){
          key.add(character);
      }
      Collections.sort(key);
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

        List<Character> key =  stringToSortedArray(word);
        //o,o,t,t
        List<Character> keyToSearch = new ArrayList<>();
        for (int i = 0 ; i < key.size()  ; i++ ){
            keyToSearch.add(key.get(i)); //o
            if (contains(keyToSearch)){
                String subtractOfWord = "";
                for (int j = 0 ; j < word.length() ; j++ ){
                    if (!keyToSearch.contains(word.charAt(j))){
                        subtractOfWord += word.charAt(j);
                    }
                }
                List<Character> subtractOfWordList = stringToSortedArray(subtractOfWord);
                if (contains(subtractOfWordList)){
                    for (String s1 : hashMap.get(keyToSearch)){// always 1 result //TODO: cédric geule !
                        for (String s2 : hashMap.get(subtractOfWordList)) {
                            if ((s1 += s2).equals(word) || (s2 += s1).equals(word))
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
