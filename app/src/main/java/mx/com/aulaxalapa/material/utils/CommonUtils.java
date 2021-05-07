package mx.com.aulaxalapa.material.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import mx.com.aulaxalapa.material.fragments.BottomNavigationBarFragment;
import mx.com.aulaxalapa.material.fragments.ButtonFragment;
import mx.com.aulaxalapa.material.fragments.CardFragment;
import mx.com.aulaxalapa.material.fragments.CheckBoxFragment;
import mx.com.aulaxalapa.material.fragments.FloatingActionButtonFragment;
import mx.com.aulaxalapa.material.fragments.MenuFragment;
import mx.com.aulaxalapa.material.fragments.SnackBarFragment;
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
            /// SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;

            // STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                    fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                    fragment = new FloatingActionButtonFragment();
                break;
            case CheckBoxFragment.TAG:
                    fragment = new CheckBoxFragment();
                break;
            case MenuFragment.TAG:
                fragment = new MenuFragment();
                break;


        }
        return fragment;
    }
}
