package mx.com.aulaxalapa.material.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.buildware.widget.indeterm.IndeterminateCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;

public class CheckBoxFragment extends Fragment {
    public static final String TAG = "Checkbox";
    private static Component mInstance;

    @BindView(R.id.cbEnable)
    CheckBox cbEnable;

    @BindView(R.id.cbEnableIndeterminate)
    IndeterminateCheckBox cbEnableIndeterminate;

    Unbinder mUnbinder;
    public static Component getInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotopRes(R.drawable.img_checkboxes);
        mInstance.setType(Constantes.SCROLL);
        return mInstance;
    }

    public CheckBoxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_check_box, container, false);

        mUnbinder = ButterKnife.bind(this,view);
        cbEnable.setOnClickListener(view1 -> {
            String status = cbEnable.isChecked()? "Active" : "Inactivo";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
            cbEnableIndeterminate.setIndeterminate(cbEnable.isChecked());
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}