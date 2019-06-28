package com.learn.springboot.utils.JSON;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONArray implements Iterable<Object>{
    private List<Object> list;

    /**
     * Constructor
     */
    public JSONArray() {
        list = new ArrayList<>();
    }


    /**
     * Constructor with param
     * @param list param
     */
    public JSONArray(List<Object> list) {
        this.list = list;
    }


    public Object get(int index) {
        Object value = list.get(index);
        return value;
    }


    public void add(Object value) {
        list.add(value);
    }


    public boolean contains(Object value) {
        return list.contains(value);
    }


    public void remove(int index) {
        list.remove(index);
    }


    public int size() {
        return list.size();
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }


    public List<Object> getList() {
        return list;
    }


    public void clear() {
        list.clear();
    }


    @Override
    public Iterator<Object> iterator() {
        return list.iterator();
    }


    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
