package com.learn.springboot.utils.JSON;

import com.couchbase.client.java.document.json.JsonObject;

import java.util.*;
import java.util.stream.Stream;

public class JSONObject implements Iterable<Map.Entry<String, Object>> {
    private Map<String, Object> map;

    /**
     * Constructor
     */
    public JSONObject() {
        map = new HashMap<>();
    }


    /**
     * Constructor with param
     * @param map param
     */
    public JSONObject(Map<String, Object> map) {
        this.map = map;
    }


    /**
     * Get String value of a key
     * @param key key value
     * @return String value
     */
    public String getString(String key) {
        CharSequence cs = (CharSequence) map.get(key);
        if (cs == null)
            return null;
        return cs.toString();
    }

    /**
     * Get integer value of a key
     * @param key String key value
     * @return Integer value
     */
    public Integer getInteger(String key) {
        Number n = (Number) map.get(key);

        if(n == null)
            return null;

        if(n instanceof Integer)
            return (Integer) n;

        return n.intValue();
    }


    /**
     * Get Object value of a key
     * @param key String key
     * @param <T> Object
     * @return Object
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        T value = (T) map.get(key);
        if(value instanceof Map)
            return (T) new JSONObject((Map) value);
        if(value instanceof List)
            return (T) new JSONObject((Map) value);
        return value;
    }


    /**
     * Check if key exists
     * @param key String key
     * @return t of f
     */
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }


    /**
     * @return key set
     */
    public Set<String> fields() {
        return map.keySet();
    }


    /**
     * Put <K, V> into map
     * @param key String
     * @param value Object
     */
    public void put(String key, Object value) throws Exception{
        Objects.requireNonNull(key);
        value = checkValue(value);
        map.put(key, value);
    }


    public void clear() {
        map.clear();
    }


    public boolean isEmpty() {
        return map.isEmpty();
    }


    public int size() {
        return map.size();
    }


    public Stream<Map.Entry<String, Object>> stream() {
        return map.entrySet().stream();
    }


    public Iterator<Map.Entry<String, Object>> iterator() {
        return new JSONObjectIterator(map.entrySet().iterator());
    }


    @Override
    public String toString() {
        return "";
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        return objectEquals(map, obj);
    }


    @Override
    public int hashCode() {
        return map.hashCode();
    }


    public Map<String, Object> getMap() {
        return map;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    private static Object checkValue(Object value) throws Exception{
        if (value == null) {
            // OK
        }
        else if (value instanceof Number) {
            // OK
        }
        else if (value instanceof Boolean) {
            // OK
        }
        else if (value instanceof String) {
            // OK
        }
        else if (value instanceof Character) {
            // OK
        }
        else if (value instanceof CharSequence) {
            value = value.toString();
        }
        else if (value instanceof JsonObject) {
            // OK
        }
        else if (value instanceof JSONArray) {
            // OK
        }
        else if (value instanceof Map) {
            value = new JSONObject((Map) value);
        }
        else if (value instanceof List) {
            value = new JSONArray((List) value);
        }
        else if (value instanceof byte[]) {
            value = Base64.getEncoder().encodeToString((byte[]) value);
        }
        else {
            throw new JSONException("");
        }

        return value;
    }

    private static boolean objectEquals(Map<?, ?> m, Object obj) {
        Map<?, ?> temp;

        if(obj instanceof JSONObject)
            temp = ((JSONObject) obj).getMap();

        else if(obj instanceof Map<?, ?>)
            temp = (Map<?, ?>) obj;

        else
            return false;

        if(m.size() != temp.size())
            return false;

        for(Map.Entry<?, ?> entry : m.entrySet()) {
            Object o = entry.getValue();
            if(o == null) {
                if (temp.get(entry.getKey()) != null)
                    return false;
            }else {
                if(!elementEquals(entry.getKey(), temp.get(entry.getKey())))
                    return false;
            }
        }

        return true;
    }

    private static boolean elementEquals(Object obj1, Object obj2){
        if(obj1 == obj2)
            return true;

        if(obj1 instanceof JSONObject)
            return objectEquals(((JSONObject) obj1).map, obj2);

        if(obj1 instanceof Map<?, ?>)
            return objectEquals((Map<?, ?>) obj1, obj2);

        if(obj1 instanceof JSONArray)
            return false;

        if(obj1 instanceof List<?>)
            return false;

        return obj1.equals(obj2);
    }

    private class JSONObjectIterator implements Iterator<Map.Entry<String, Object>> {
        Iterator<Map.Entry<String, Object>> iterator;

        JSONObjectIterator(Iterator<Map.Entry<String, Object>> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Map.Entry<String, Object> next() {
            Map.Entry<String, Object> entry = iterator.next();
//
//            if(entry.getValue() instanceof Map)
//
//
//            if(entry.getValue() instanceof List)
//
            return entry;
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}