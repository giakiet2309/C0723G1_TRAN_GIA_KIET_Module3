package model;

public class QuanLyChatLieu {
    private int id;

    private String nameId;

    private String nameType;

    private String describe;

    public QuanLyChatLieu( String nameId, String nameType, String describe) {
        this.nameId = nameId;
        this.nameType = nameType;
        this.describe = describe;
    }

    public QuanLyChatLieu(int id, String nameId, String nameType, String describe) {
        this.id = id;
        this.nameId = nameId;
        this.nameType = nameType;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
