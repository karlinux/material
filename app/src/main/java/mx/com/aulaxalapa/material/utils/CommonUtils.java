package mx.com.aulaxalapa.material.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import mx.com.aulaxalapa.material.fragments.BottomNavigationBarFragment;
import mx.com.aulaxalapa.material.fragments.ButtonFragment;
import mx.com.aulaxalapa.material.fragments.SnackBarFragment;
import mx.com.aulaxalapa.material.fragments.TextFieldFragment;
import mx.com.aulaxalapa.material.fragments.TextFieldFragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRest){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction().add(contentRest, fragment)
        .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                    fragment = new SnackBarFragment();
                break;
            case TextFieldFragment.TAG:
                    fragment = new TextFieldFragment();
                break;
        }
        return fragment;
    }
}
