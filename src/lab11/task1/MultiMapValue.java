package lab11.task1;

import java.util.*;

public class MultiMapValue<K, V> {
    HashMap<K, ArrayList<V>> hashMap;

    {
        hashMap = new HashMap<>();
    }

    public void add(K key, V value) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(value);
        } else {
            ArrayList<V> list = new ArrayList<>();
            list.add(value);
            hashMap.put(key, list);
        }
    }

    public void addAll(K key,
                       List<V> values) {
        for (V value : values) this.add(key, value);
    }


    public void addAll(MultiMapValue<K, V> map) {
        for (K key : map.hashMap.keySet()) {
            this.addAll(key, map.getValues(key));
        }
    }

    public V getFirst(K key) {
        if (hashMap.containsKey(key)) {
            return hashMap.get(key).get(0);
        }

        return null;
    }

    public List<V> getValues(K key) {
        return hashMap.get(key);
    }

    public boolean containsKey(K key) {
        return hashMap.containsKey(key);
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public List<V> remove(K key) {
        if (hashMap.containsKey(key)) {
            List<V> deletedList = hashMap.get(key);
            hashMap.remove(key, deletedList);
            hashMap.remove(key);

            return deletedList;
        }

        return null;
    }

    public int size() {
        return hashMap.size();
    }
}