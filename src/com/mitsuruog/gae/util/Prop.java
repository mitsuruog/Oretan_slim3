package com.mitsuruog.gae.util;

import java.io.IOException;
import java.util.Properties;

public class Prop {

    private Properties p = new Properties();

    /**
     *
     * @param path
     * @throws IOException
     */
    public Prop(String path) throws IOException {
        p.load(this.getClass().getClassLoader().getResourceAsStream(path));
    }

    /**
     *
     * @param key
     * @return
     */
    public String get(String key){
        return p.getProperty(key);
    }
}
