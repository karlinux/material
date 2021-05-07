package mx.com.aulaxalapa.material;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.com.aulaxalapa.material.adapters.ComponentAdapter;
import mx.com.aulaxalapa.material.fragments.BottomNavigationBarFragment;
import mx.com.aulaxalapa.material.fragments.ButtonFragment;
import mx.com.aulaxalapa.material.fragments.CardFragment;
import mx.com.aulaxalapa.material.fragments.CheckBoxFragment;
import mx.com.aulaxalapa.material.fragments.FloatingActionButtonFragment;
import mx.com.aulaxalapa.material.fragments.MenuFragment;
import mx.com.aulaxalapa.material.fragments.SnackBarFragment;
import mx.com.aulaxalapa.material.fragments.TextFieldFragment;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;
import mx.com.aulaxalapa.material.utils.OnClickListener;

public class InicioMaterial extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ButterKnife.bind(this);
        configAdapter();
        configRecycleView();
    }

    private void configAdapter(){
        mAdapter =  new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getInstance());
        mAdapter.add(BottomNavigationBarFragment.getInstance());
        mAdapter.add(SnackBarFragment.getInstance());
        mAdapter.add(TextFieldFragment.getInstance());
        mAdapter.add(FloatingActionButtonFragment.getInstance());
        mAdapter.add(CheckBoxFragment.getInstance());
        mAdapter.add(CardFragment.getInstance());
        mAdapter.add(MenuFragment.getInstance());
        mAdapter.reverse();
    }

    private void configRecycleView(){
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(Component component) {
        Intent intent;
        if( component.getType() == Constantes.SCROLL){
            intent = new Intent(getApplicationContext(), ScrollActivity.class);
        }else{
            intent = new Intent(getApplicationContext(), StaticActivity.class);
        }
        intent.putExtra(Constantes.ARG_NAME, component.getName());
        startActivity(intent);
    }
}