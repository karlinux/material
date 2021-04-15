package mx.com.aulaxalapa.material.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRest){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction().add(contentRest, fragment)
        .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){

        }
        return fragment;
    }
}
