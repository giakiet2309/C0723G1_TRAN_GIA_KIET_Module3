package model;

public class QuanLySize {
    private int id;
    private String sizeId;
    private String nameSize;
    private String describe;

    public QuanLySize(int id, String sizeId, String nameSize, String describe) {
        this.id = id;
        this.sizeId = sizeId;
        this.nameSize = nameSize;
        this.describe = describe;
    }

    public QuanLySize(String sizeId, String nameSize, String describe) {
        this.sizeId = sizeId;
        this.nameSize = nameSize;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getNameSize() {
        return nameSize;
    }

    public void setNameSize(String nameSize) {
        this.nameSize = nameSize;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
