package com.zhuoxin.shopping.entity;

/**
 * Created by Administrator on 2016/9/1.
 */
public class Shop {
    public int s_id;
    public String img_path;
    public String max_path;
    public String remark;
    public String name;
    public double price;
    public double s_price;
    public int number;
    public int numbers;
    public Shop(int s_id, String img_path, String max_path, String remark, String name, double price, double s_price,
                int number, int numbers) {
        super();
        this.s_id = s_id;
        this.img_path = img_path;
        this.max_path = max_path;
        this.remark = remark;
        this.name = name;
        this.price = price;
        this.s_price = s_price;
        this.number = number;
        this.numbers = numbers;
    }
    public Shop() {
        super();
    }
    public int getS_id() {
        return s_id;
    }
    public void setS_id(int s_id) {
        this.s_id = s_id;
    }
    public String getImg_path() {
        return img_path;
    }
    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
    public String getMax_path() {
        return max_path;
    }
    public void setMax_path(String max_path) {
        this.max_path = max_path;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getS_price() {
        return s_price;
    }
    public void setS_price(double s_price) {
        this.s_price = s_price;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumbers() {
        return numbers;
    }
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }


}
