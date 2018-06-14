package com.jesper.seckill.dto;

public class IdVersion {
    private long id;
    private int version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "IdVersion{" +
                "id=" + id +
                ", version=" + version +
                '}';
    }
}

