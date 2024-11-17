package com.example.obiexplorermobile.dto;

public class SpinnerItem {

    private String value;
    private String label;

    public SpinnerItem(String id, String name) {
        this.value = id;
        this.label = name;
    }

    public String getId() {
        return value;
    }

    public String getName() {
        return label;
    }

    @Override
    public String toString() {
        return label; // Este valor será exibido no Spinner
    }
}
