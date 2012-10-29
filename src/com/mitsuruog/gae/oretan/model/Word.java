package com.mitsuruog.gae.oretan.model;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Word implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String en;
    private String ja;
    private Date registDate = new Date();
    
    
    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Word other = (Word) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    /**
     * enを取得します。
     * @return en
     */
    public String getEn() {
        return en;
    }

    /**
     * enを設定します。
     * @param en en
     */
    public void setEn(String en) {
        this.en = en;
    }

    /**
     * jaを取得します。
     * @return ja
     */
    public String getJa() {
        return ja;
    }

    /**
     * jaを設定します。
     * @param ja ja
     */
    public void setJa(String ja) {
        this.ja = ja;
    }

    /**
     * registDateを取得します。
     * @return registDate
     */
    public Date getRegistDate() {
        return registDate;
    }

    /**
     * registDateを設定します。
     * @param registDate registDate
     */
    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }
}
