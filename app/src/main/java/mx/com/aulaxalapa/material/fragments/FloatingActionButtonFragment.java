package mx.com.aulaxalapa.material.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;

public class FloatingActionButtonFragment extends Fragment {

    public static final String TAG = "Floating Action Button";
    private static Component mInstance;

    Unbinder mUnbinder;

    public static Component getInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotopRes(R.drawable.img_fab_default);
        mInstance.setType(Constantes.SCROLL);
        return mInstance;
    }

    public FloatingActionButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_floating_action_button, container, false);
    }
}