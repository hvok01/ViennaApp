package com.example.viennaapp.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.viennaapp.R;
import com.example.viennaapp.models.DuenioEvento;
import com.example.viennaapp.request.MisSharedPreferences;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView tvBienvenido,tvNombre,tvCorreo;
    private MisSharedPreferences preferencias;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        homeViewModel.getUsuario();

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        tvBienvenido = root.findViewById(R.id.tvBienvenido);
        tvNombre = root.findViewById(R.id.tvNombre);
        tvCorreo = root.findViewById(R.id.tvCorreo);

        final Button btn = root.findViewById(R.id.btnEditarPerfil);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.editarPerfil);
            }
        });
        homeViewModel.getDuenioEventoLiveData().observe(this, new Observer<DuenioEvento>() {
            @Override
            public void onChanged(DuenioEvento duenioEvento) {
                if(duenioEvento!=null) {
                    String bienvenida = "Bienvenido "+duenioEvento.getNombre();
                    String nombre = duenioEvento.getNombre();
                    String correo = duenioEvento.getCorreo();

                    tvBienvenido.setText(bienvenida);
                    tvNombre.setText(nombre);
                    tvCorreo.setText(correo);
                }
            }
        });
        return root;
    }
}