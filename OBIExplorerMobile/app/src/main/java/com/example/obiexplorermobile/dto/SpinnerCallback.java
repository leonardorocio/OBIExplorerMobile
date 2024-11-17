package com.example.obiexplorermobile.dto;

import java.util.List;

public interface SpinnerCallback {
    void onSuccess(List<SpinnerItem> list);
    void onFailure(Exception e);
}
