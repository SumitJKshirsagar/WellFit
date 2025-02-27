package com.example.wellfit;


import android.annotation.SuppressLint;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Field;

public class BottomNavHelp {

    @SuppressLint("RestrictedApi")
    public static void removeShiftMode(BottomNavigationView view){
        BottomNavigationMenuView menu = (BottomNavigationMenuView) view.getChildAt(0);
        try{
            Field shiftingMode = menu.getClass().getDeclaredField("mShiftMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menu,false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i<menu.getChildCount(); i++){
                BottomNavigationItemView item = (BottomNavigationItemView)menu.getChildAt(i);
                item.setChecked(item.getItemData().isChecked());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
