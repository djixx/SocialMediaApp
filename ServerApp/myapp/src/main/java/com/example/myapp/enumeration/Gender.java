package com.example.myapp.enumeration;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Gender {
    GENDER_MALE("GENDER_MALE"),
    GENDER_FEMALE("GENDER_FEMALE"),
    GENDER_OTHER("GENDER_OTHER");

    private final String gender; //string that represents the status

    Gender(String gender){
    this.gender= gender;
    }


}
