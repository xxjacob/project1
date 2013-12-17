package com.ideax.project1.common;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.ideax.common.KVStore;

@Service("kvStore")
public class LocalMapStore implements KVStore {

    public ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<Object, Object>();

    public <T> T get(Object key, Class<T> clz) {
        return clz.cast(map.get(key));
    }

    public Object get(Object key) {
        return map.get(key);
    }

    public <T> void put(Object key, T value) {
        map.put(key, value);
    }

    @Override
    public void clear() {
        map.clear();
    }

}
