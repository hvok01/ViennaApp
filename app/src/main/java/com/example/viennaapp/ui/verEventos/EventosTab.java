package com.example.viennaapp.ui.verEventos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viennaapp.R;
import com.example.viennaapp.models.Evento;

import java.util.List;

public class EventosTab extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TextView tvNombreEvento, tvFechaEvento, tvCantidadAsistentes, tvPrecioEntrada;
    private CheckBox chbCancelado;
    private Button btnGuardar;
    private Evento evento;
    private VerEventosViewModel verEventosViewModel;
    private int id;

    public EventosTab() {
        // Required empty public constructor
    }

    public EventosTab(Evento evento) {
        this.evento = evento;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_eventos_tab, container, false);

        tvNombreEvento = root.findViewById(R.id.tvNombreEvento);
        tvFechaEvento = root.findViewById(R.id.tvFechaEvento);
        tvCantidadAsistentes = root.findViewById(R.id.tvCantidadAsistentes);
        tvPrecioEntrada = root.findViewById(R.id.tvPrecioEntrada);
        chbCancelado = root.findViewById(R.id.chbCancelado);
        btnGuardar = root.findViewById(R.id.btnGuardar);

        verEventosViewModel = ViewModelProviders.of(this).get(VerEventosViewModel.class);

        id = evento.getIdEvento();
        tvNombreEvento.setText(evento.getNombre()+"");
        tvFechaEvento.setText(evento.getInicioEvento()+"");
        tvCantidadAsistentes.setText(evento.getCantidadAsistentes()+"");
        tvPrecioEntrada.setText(evento.getPrecioEntrada()+"");


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(getActivity(),R.style.alertDialogTheme)
                        .setTitle("Guardar cambios:")
                        .setMessage("¿Desea cancelar el evento?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(chbCancelado.isChecked()){

                                    verEventosViewModel.cancelarEvento(id);

                                } else {
                                    Toast.makeText(getActivity(), "Se guardará si el checkbox cancelado esta activado", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();

            }
        });


        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
