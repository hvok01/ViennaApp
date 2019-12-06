package com.example.viennaapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viennaapp.R;

import java.util.ArrayList;
import java.util.List;

public class ItemContratoAdapter  extends ArrayAdapter<Contrato> {

    private Context context;
    private List<Contrato> lista;
    private LayoutInflater li;

    public ItemContratoAdapter(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        View itemView = convertView;

        if(itemView == null){
            itemView = li.inflate(R.layout.item_ver_contratos,parent,false);
        }

        Contrato item = lista.get(position);
        TextView tvNombreEvento= itemView.findViewById(R.id.tvNombreEvento);
        TextView tvPrecioContrato = itemView.findViewById(R.id.tvPrecioContrato);
        TextView tvCancelado = itemView.findViewById(R.id.tvCancelado);

        tvNombreEvento.setText(item.getEvento().getNombre()+"");
        tvPrecioContrato.setText(item.getPrecioFinal()+"");

        if(item.getPagado()==1){
            tvCancelado.setText("Sí");
        }else{
            tvCancelado.setText("No");
        }


        return itemView;
    }
}
