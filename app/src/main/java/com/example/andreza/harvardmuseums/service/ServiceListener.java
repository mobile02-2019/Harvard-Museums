package com.example.andreza.harvardmuseums.service;

import com.example.andreza.harvardmuseums.model.Exhibition;

public interface ServiceListener {
    void onSucess(Object object);
    void onError(Throwable throwable);


}
