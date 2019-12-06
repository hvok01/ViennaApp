package com.example.viennaapp.ui.solicitarEvento;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.viennaapp.R;
import com.example.viennaapp.models.Evento;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SolicitarEventoFragment extends Fragment {

    private SolicitarEventoViewModel solicitarEventoViewModel;
    private EditText etNombreEvento, etPrecioEntrada;
    private TextView etFechaInicio, etHoraDelEvento;
    private Spinner spnDuracion, spnSalas;
    private Button btnSolicitarEvento;
    private int anio,mes,dia,hora,minutos,segundos;
    private int anio2, mes2, dia2, hora2, minutos2, segundos2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        solicitarEventoViewModel = ViewModelProviders.of(this).get(SolicitarEventoViewModel.class);

        View root = inflater.inflate(R.layout.fragment_solicitar_evento, container, false);

        etNombreEvento = root.findViewById(R.id.etNombreEvento);
        etFechaInicio = root.findViewById(R.id.etFechaInicio);
        etPrecioEntrada = root.findViewById(R.id.etPrecioEntrada);
        etHoraDelEvento = root.findViewById(R.id.etHoraDelEvento);

        spnDuracion = root.findViewById(R.id.spnDuracion);
        spnSalas = root.findViewById(R.id.spnSalas);
        btnSolicitarEvento = root.findViewById(R.id.btnSolicitarEvento);

        Calendar c = Calendar.getInstance();
        anio = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DATE);
        hora = c.get(Calendar.HOUR);
        minutos = c.get(Calendar.MINUTE);
        segundos = 00;


        etFechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),R.style.alertDialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        etFechaInicio.setText(i+"/"+i1+"/"+i2+"");
                        anio2 = i;
                        mes2 = i1;
                        dia2 = i2;
                    }
                },anio,mes,dia);
                datePickerDialog.show();

            }
        });

        etHoraDelEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),R.style.alertDialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        etHoraDelEvento.setText(i+":"+i1+":"+segundos+"");
                        hora2 = i;
                        minutos2 = i1;
                        segundos2 = 00;
                    }
                },hora,minutos,true);
                timePickerDialog.show();
            }
        });



        btnSolicitarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(getActivity(),R.style.alertDialogTheme)
                        .setTitle("Solicitar Evento")
                        .setMessage("¿Desea solicitar este evento?")
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(etFechaInicio.getText().toString().isEmpty() || etNombreEvento.getText().toString().isEmpty() || etPrecioEntrada.getText().toString().isEmpty() || etHoraDelEvento.getText().toString().isEmpty()){
                                    Toast.makeText(getActivity(), "Completar todos los campos por favor.", Toast.LENGTH_SHORT).show();
                                } else {

                                    //fecha acutal
                                    Calendar calendar = Calendar.getInstance();

                                    //fecha elegida por el usuario
                                    Calendar fechaElegida = Calendar.getInstance();
                                    fechaElegida.set(anio2,mes2,dia2,hora2,minutos2,00);
                                    String fechaElegidaString = DateFormat.getDateTimeInstance().format(fechaElegida.getTime());

                                    if(fechaElegida.before(calendar)){
                                        Toast.makeText(getActivity(), "La fecha seleccionada no es válida", Toast.LENGTH_SHORT).show();
                                    } else {

                                        Calendar fechaFinEvento = Calendar.getInstance();
                                        String nombreEvento = etNombreEvento.getText().toString();
                                        String precio = etPrecioEntrada.getText().toString();
                                        String nombreSala = spnSalas.getSelectedItem().toString();

                                        switch (spnDuracion.getSelectedItem().toString()){
                                            case "30 minutos":
                                                fechaFinEvento.set(anio2,mes2,dia2,hora2,minutos2+30,00);
                                                String fin = DateFormat.getDateTimeInstance().format(fechaFinEvento.getTime());
                                                solicitarEventoViewModel.enviarSolicitudEvento(nombreSala,nombreEvento,fechaElegidaString,fin,precio);
                                                break;
                                            case "1 hora":
                                                fechaFinEvento.set(anio2,mes2,dia2,hora2+1,minutos2,00);
                                                String finMasUnaHora = DateFormat.getDateTimeInstance().format(fechaFinEvento.getTime());

                                                solicitarEventoViewModel.enviarSolicitudEvento(nombreSala,nombreEvento,fechaElegidaString,finMasUnaHora,precio);
                                                break;
                                            case "1 hora y media":
                                                fechaFinEvento.set(anio2,mes2,dia2,hora2+1,minutos2+30,00);
                                                String finMasUnaHoraYMedia = DateFormat.getDateTimeInstance().format(fechaFinEvento.getTime());
                                                solicitarEventoViewModel.enviarSolicitudEvento(nombreSala,nombreEvento,fechaElegidaString,finMasUnaHoraYMedia,precio);

                                                break;
                                            case "2 horas":
                                                fechaFinEvento.set(anio2,mes2,dia2,hora2+2,minutos2,00);
                                                String finDosHoras = DateFormat.getDateTimeInstance().format(fechaFinEvento.getTime());
                                                solicitarEventoViewModel.enviarSolicitudEvento(nombreSala,nombreEvento,fechaElegidaString,finDosHoras,precio);

                                                break;
                                            case "3 horas" :
                                                fechaFinEvento.set(anio2,mes2,dia2,hora2+3,minutos2,00);
                                                String finTresHoras = DateFormat.getDateTimeInstance().format(fechaFinEvento.getTime());
                                                solicitarEventoViewModel.enviarSolicitudEvento(nombreSala,nombreEvento,fechaElegidaString,finTresHoras,precio);

                                                break;
                                        }
                                    }
                                }
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();

            }
        });

        solicitarEventoViewModel.getEventoViewModel().observe(this, new Observer<Evento>() {
            @Override
            public void onChanged(Evento evento) {

            }
        });
        return root;
    }


}