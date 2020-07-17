package com.harsharjeria.courseapp.Utils;

import android.widget.EditText;

import com.harsharjeria.courseapp.Models.Classes;
import com.harsharjeria.courseapp.Models.Websites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {

    public Functions() {

    }

    public Double stringToDouble(String input){
        return Double.valueOf(input);
    }

    public boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public boolean validateEmail(String data){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(data).matches();
    }

    public Websites[] myWebsites(){
        return new Websites[]{
                new Websites("Udemy", "udemy", "https://www.udemy.com/", "https://www.udemy.com/staticx/udemy/images/v6/default-meta-image.png"),
                new Websites("Vedantu", "vedantu", "https://www.vedantu.com/", "https://ecoursys.com/wp-content/uploads/vedantu900.png"),
                new Websites("Meritnation", "meritnation", "https://www.meritnation.com/", "https://upload.wikimedia.org/wikipedia/commons/c/cd/Meritnation-logo.jpg"),
                new Websites("Byjus", "byjus", "https://www.byjus.com/", "https://indiaeducationdiary.in/wp-content/uploads/2017/10/BYJUS_NEW_LOGO.png"),
                new Websites("Unacademy", "unacademy", "https://unacademy.com/", "https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/unacademy_505_130320103419jpg_200320075927.jpg")
        };
    }

    public Classes[] myClasses(){
        return new Classes[]{
                new Classes(1, "First", "https://www.udemy.com/"),
                new Classes(2, "Second", "https://www.udemy.com/"),
                new Classes(3, "Third", "https://www.udemy.com/"),
                new Classes(4, "Fourth", "https://www.udemy.com/"),
                new Classes(5, "Fifth", "https://www.udemy.com/"),
                new Classes(6, "Sixth", "https://www.udemy.com/"),
                new Classes(7, "Seventh", "https://www.udemy.com/"),
        };
    }
}
