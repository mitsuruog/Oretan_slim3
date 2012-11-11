package com.mitsuruog.gae.oretan.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-12 00:01:58")
/** */
public final class WordMeta extends org.slim3.datastore.ModelMeta<com.mitsuruog.gae.oretan.model.Word> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mitsuruog.gae.oretan.model.Word> en = new org.slim3.datastore.StringAttributeMeta<com.mitsuruog.gae.oretan.model.Word>(this, "en", "en");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mitsuruog.gae.oretan.model.Word> ja = new org.slim3.datastore.StringAttributeMeta<com.mitsuruog.gae.oretan.model.Word>(this, "ja", "ja");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mitsuruog.gae.oretan.model.Word, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.mitsuruog.gae.oretan.model.Word, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mitsuruog.gae.oretan.model.Word, java.util.Date> registDate = new org.slim3.datastore.CoreAttributeMeta<com.mitsuruog.gae.oretan.model.Word, java.util.Date>(this, "registDate", "registDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mitsuruog.gae.oretan.model.Word, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.mitsuruog.gae.oretan.model.Word, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final WordMeta slim3_singleton = new WordMeta();

    /**
     * @return the singleton
     */
    public static WordMeta get() {
       return slim3_singleton;
    }

    /** */
    public WordMeta() {
        super("Word", com.mitsuruog.gae.oretan.model.Word.class);
    }

    @Override
    public com.mitsuruog.gae.oretan.model.Word entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.mitsuruog.gae.oretan.model.Word model = new com.mitsuruog.gae.oretan.model.Word();
        model.setEn((java.lang.String) entity.getProperty("en"));
        model.setJa((java.lang.String) entity.getProperty("ja"));
        model.setKey(entity.getKey());
        model.setRegistDate((java.util.Date) entity.getProperty("registDate"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.mitsuruog.gae.oretan.model.Word m = (com.mitsuruog.gae.oretan.model.Word) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("en", m.getEn());
        entity.setProperty("ja", m.getJa());
        entity.setProperty("registDate", m.getRegistDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.mitsuruog.gae.oretan.model.Word m = (com.mitsuruog.gae.oretan.model.Word) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.mitsuruog.gae.oretan.model.Word m = (com.mitsuruog.gae.oretan.model.Word) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.mitsuruog.gae.oretan.model.Word m = (com.mitsuruog.gae.oretan.model.Word) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.mitsuruog.gae.oretan.model.Word m = (com.mitsuruog.gae.oretan.model.Word) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.mitsuruog.gae.oretan.model.Word m = (com.mitsuruog.gae.oretan.model.Word) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getEn() != null){
            writer.setNextPropertyName("en");
            encoder0.encode(writer, m.getEn());
        }
        if(m.getJa() != null){
            writer.setNextPropertyName("ja");
            encoder0.encode(writer, m.getJa());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getRegistDate() != null){
            writer.setNextPropertyName("registDate");
            encoder0.encode(writer, m.getRegistDate());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.mitsuruog.gae.oretan.model.Word jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.mitsuruog.gae.oretan.model.Word m = new com.mitsuruog.gae.oretan.model.Word();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("en");
        m.setEn(decoder0.decode(reader, m.getEn()));
        reader = rootReader.newObjectReader("ja");
        m.setJa(decoder0.decode(reader, m.getJa()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("registDate");
        m.setRegistDate(decoder0.decode(reader, m.getRegistDate()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}