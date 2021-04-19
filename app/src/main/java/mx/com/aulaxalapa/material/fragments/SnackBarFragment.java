package mx.com.aulaxalapa.material.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;

public class SnackBarFragment extends Fragment {

    public static final String TAG = "SnackBar";
    private static Component mInstance;

    Unbinder mUnbinder;

    @BindView(R.id.containerMain)
    FrameLayout containerMain;

    public static Component getInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotopRes(R.drawable.img_singleline_action);
        mInstance.setType(Constantes.STATIC);
        return mInstance;
    }

    public SnackBarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_snack_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        Snackbar.make(containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("Volver", view1 -> getActivity().finish())
                .show();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}