package com.example.expensemanager.Classes;

public class Categories {
    String category;


    @Override
    public String toString() {
        return "Categories{" +
                "category='" + category + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Categories(String category) {
        this.category = category;
    }
    public Categories() {
    }

}
