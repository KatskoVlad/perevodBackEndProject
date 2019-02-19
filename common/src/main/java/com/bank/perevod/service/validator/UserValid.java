package com.bank.perevod.service.validator;

import com.bank.perevod.domain.to.User;

public class UserValid {


    public static ValidatorInterface<User> getInstance(){
        ValidatorInterface<User> instance = null;
        return instance;
    }

}
