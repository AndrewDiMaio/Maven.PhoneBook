package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    Map<String, List<String>> phoneMap;

    public PhoneBook(Map<String, List<String>> map) {
        this.phoneMap = map;
    }

    public PhoneBook() {
        phoneMap = new LinkedHashMap<String,List<String>>();
    }

    public void add(String name, String phoneNumber) {
        List<String> temp = new ArrayList<>();
        temp.add(phoneNumber);
        phoneMap.put(name, temp);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> temp = new ArrayList<>();
                temp.addAll(Arrays.asList(phoneNumbers));
        this.phoneMap.put(name, temp);
    }

    public void remove(String name) {
        this.phoneMap.remove(name);
    }

    public Boolean hasEntry(String name) {
        for (Map.Entry<String, List<String>> check : phoneMap.entrySet())
            if (check.getValue().contains(name)) {
                return true;
            }
        return phoneMap.containsKey(name);
    }

    public List<String> lookup(String name) {

        return this.phoneMap.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

        for(Map.Entry<String, List<String>> name : this.phoneMap.entrySet()) {
            if(name.getValue().contains(phoneNumber))
            return name.getKey();
            System.out.println(name.getKey());
        }return null;
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();

        for(Map.Entry<String, List<String>> name : this.phoneMap.entrySet()) {
            names.add(name.getKey());
        }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phoneMap;
    }
}
