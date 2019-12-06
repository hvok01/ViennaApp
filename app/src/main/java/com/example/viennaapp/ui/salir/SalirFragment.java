package com.example.viennaapp.ui.salir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.viennaapp.R;
import com.example.viennaapp.ui.login.LoginActivity;
import com.example.viennaapp.ui.main.MainActivity;

public class SalirFragment extends Fragment {

    private SalirViewModel salirViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        salirViewModel = ViewModelProviders.of(this).get(SalirViewModel.class);
        View root = inflater.inflate(R.layout.fragment_salir, container, false);
        final TextView textView = root.findViewById(R.id.text_share);

        textView.setText("Hasta luego!");

        new AlertDialog.Builder(getActivity(),R.style.alertDialogTheme)
                .setTitle("Salir:")
                .setMessage("¿Desea cerrar la sesion?")
                .setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        salirViewModel.salir();

                        Intent a = new Intent(getActivity(), LoginActivity.class);
                        startActivity(a);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent a = new Intent(getActivity(), MainActivity.class);
                        startActivity(a);
                    }
                }).show();


        return root;
    }
}