package mx.com.aulaxalapa.material.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.OnClickListener;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder> {

    private List<Component> mComponent;
    private OnClickListener mlistener;

    public ComponentAdapter(List<Component> component, OnClickListener listener) {
        this.mComponent = component;
        this.mlistener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Component component = mComponent.get(position);
        holder.setClickListener(mlistener, component);
        holder.tvname.setText(component.getName());
        holder.imgFoto.setImageResource(component.getPhtpRes());
    }

    @Override
    public int getItemCount() {
        return mComponent.size();
    }
    public void add(Component component){
        if(mComponent.contains(component)){
            mComponent.add(component);
            notifyItemInserted(mComponent.size() - 1);
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imFoto)
        AppCompatImageView imgFoto;
        @BindView(R.id.tvName)
        TextView tvname;

        View view;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           this.view = itemView;
           ButterKnife.bind(this,itemView);
       }

       void setClickListener(OnClickListener listener, Component component){
            view.setOnClickListener(view -> listener.onClick(component));
       }
   }
}
