package com.example.cmpt276group05.model;

public class ViolationEntity extends BaseEntity {
    private String cirtical;
    private String desc;
    private String repeat;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCirtical() {
        return cirtical;
    }

    public void setCirtical(String cirtical) {
        this.cirtical = cirtical;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }
}
