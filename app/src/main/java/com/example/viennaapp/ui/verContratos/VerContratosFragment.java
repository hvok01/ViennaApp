package com.example.viennaapp.ui.verContratos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.viennaapp.R;
import com.example.viennaapp.models.Contrato;
import com.example.viennaapp.models.ItemContratoAdapter;

import java.util.ArrayList;
import java.util.List;

public class VerContratosFragment extends Fragment {

    private VerContratosViewModel verContratosViewModel;
    private ListView lvContratos;
    private ArrayAdapter<Contrato> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        verContratosViewModel = ViewModelProviders.of(this).get(VerContratosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_ver_contratos, container, false);

        lvContratos = root.findViewById(R.id.lvContratos);

        verContratosViewModel.traerContratosByDuenio();

        verContratosViewModel.getLista().observe(this, new Observer<List<Contrato>>() {
            @Override
            public void onChanged(List<Contrato> contratos) {

                if(contratos!=null){
                    adapter = new ItemContratoAdapter(getActivity(),R.layout.item_ver_contratos,contratos,getLayoutInflater());
                    lvContratos.setAdapter(adapter);
                }

            }
        });



        return root;
    }
}