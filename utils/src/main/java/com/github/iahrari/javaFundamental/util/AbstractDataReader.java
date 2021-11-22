package com.github.iahrari.javaFundamental.util;

import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractDataReader<T> implements Runnable {
    protected final Set<T> data;
    protected final String readFromFile;

    public AbstractDataReader(String readFromFile){
        this.data = new HashSet<>();
        this.readFromFile = readFromFile;
    }

    public Iterator<T> getData(){
        return data.iterator();
    }
}
