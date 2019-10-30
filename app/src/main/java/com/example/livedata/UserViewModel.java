package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    private User.UserBuilder userBuilder;
    private MutableLiveData<User> user;

    public UserViewModel() {
        userBuilder = new User.UserBuilder();
        user = new MutableLiveData<>(userBuilder.build());
    }

    public void setName(String name) {
        userBuilder.withName(name);
        user.setValue(userBuilder.build());
    }

    public MutableLiveData<User> getUser() {
        return user;
    }
}