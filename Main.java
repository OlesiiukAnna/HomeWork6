package org.anna.Task_6;

public class Main {
    public static void main(String[] args) {
        MyMap myMap = new MyHashMap();
        myMap.put("1", "asdf");
        myMap.put("2", "qwert");
        myMap.put("3", "zxcv");
        System.out.println("myMap: " + myMap);
        System.out.println("put() element with key that already exists: \n" +
                myMap.put("1", "zzz"));
        System.out.println(myMap + "\n");

        System.out.println("containsKey(\"3\"): " + myMap.containsKey("3"));
        System.out.println("get(\"1\"): " + myMap.get("1"));
        System.out.println("isEmpty(): " + myMap.isEmpty());
        System.out.println("size(): " + myMap.size());
        System.out.println("remove(\"2\"): " + myMap.remove("2"));
        System.out.println(myMap + "\n");

        myMap.clear();
        System.out.println("myMap clear(): " + myMap + "\n");

        MySet set = new MyHashSet();
        set.add("asdf");
        set.add("qwer");
        set.add("zxcv");

        System.out.println("set: " + set);
        System.out.println("add() element that already exists: \n" +
                set.add("asdf"));
        System.out.println(set + "\n");

        System.out.println("contains(\"asdf\"): " + set.contains("asdf"));
        System.out.println("isEmpty(): " + set.isEmpty());
        System.out.println("size(): " + set.size());
        System.out.println("remove(\"qwer\"): " + set.remove("qwer"));
        System.out.println(set + "\n");

        set.clear();
        System.out.println("set clear(): " + set + "\n");
    }

}
