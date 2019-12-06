package com.example.viennaapp.ui.editarPerfil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.viennaapp.R;
import com.example.viennaapp.models.DuenioEvento;
import com.example.viennaapp.ui.home.HomeViewModel;
import com.example.viennaapp.ui.login.LoginActivity;

public class EditarPerfil extends Fragment {

    private EditText etNombre,etApellido,etClave,etRepetirClave;
    private Button btnGuardar, btnDarBaja;
    private EditarPerfilViewModel editarPerfilViewModel;

    public EditarPerfil() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_editar_perfil, container, false);

        etNombre = root.findViewById(R.id.etNombre);
        etApellido = root.findViewById(R.id.etApellido);
        etClave = root.findViewById(R.id.etClave);
        etRepetirClave = root.findViewById(R.id.etRepetirClave);
        btnGuardar = root.findViewById(R.id.btnGuardar);
        btnDarBaja = root.findViewById(R.id.btnDarBaja);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(getActivity(),R.style.alertDialogTheme)
                        .setTitle("Guardar cambios:")
                        .setMessage("¿Desea guardar estos cambios?")
                        .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(etNombre.getText().toString().isEmpty() || etApellido.getText().toString().isEmpty() || etClave.getText().toString().isEmpty() || !etClave.getText().toString().equals(etRepetirClave.getText().toString())){
                                    Toast.makeText(getActivity(), "error: datos invalidos o incompletos", Toast.LENGTH_SHORT).show();
                                } else {
                                    DuenioEvento logeado = new DuenioEvento();
                                    logeado.setNombre(etNombre.getText()+"");
                                    logeado.setApellido(etApellido.getText()+"");
                                    logeado.setClave(etClave.getText()+"");
                                    editarPerfilViewModel.guardarDuenio(logeado);
                                    Toast.makeText(getActivity(), "Guardando...", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();



            }
        });

        btnDarBaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(getActivity(),R.style.alertDialogTheme)
                        .setTitle("Desactivar la cuenta:")
                        .setMessage("¿Desea desactivar su cuenta?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                editarPerfilViewModel.darDeBaja();

                                editarPerfilViewModel.salir();

                                Intent a = new Intent(getActivity(), LoginActivity.class);
                                startActivity(a);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();

            }
        });

        editarPerfilViewModel = ViewModelProviders.of(this).get(EditarPerfilViewModel.class);

        editarPerfilViewModel.getUsuario();

        editarPerfilViewModel.getDuenioEventoLiveData().observe(this, new Observer<DuenioEvento>() {
            @Override
            public void onChanged(DuenioEvento duenioEvento) {
                if(duenioEvento!=null) {
                    String nombre = duenioEvento.getNombre();
                    String apellido = duenioEvento.getApellido();

                    etNombre.setText(nombre);
                    etApellido.setText(apellido);

                }
            }
        });


        return root;
    }


    //No eliminar esta interfaz
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
