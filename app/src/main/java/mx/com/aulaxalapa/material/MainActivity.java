package mx.com.aulaxalapa.material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;
import mx.com.aulaxalapa.material.adapters.ComponentAdapter;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configAdapter();
        configRecycleView();
    }

    private void configAdapter(){
        mAdapter =  new ComponentAdapter(new ArrayList<>(), this);

    }

    private void configRecycleView(){
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(Component component) {

    }
}