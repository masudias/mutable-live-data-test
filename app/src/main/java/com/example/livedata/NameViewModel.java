package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {

    private MutableLiveData<String> currentName;

    public NameViewModel() {
        currentName = new MutableLiveData<>("Initial value");
    }

    public MutableLiveData<String> getCurrentName() {
        return currentName;
    }
}