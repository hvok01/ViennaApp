package com.example.viennaapp.ui.editarPerfil;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.viennaapp.models.DuenioEvento;
import com.example.viennaapp.request.ApiClient;
import com.example.viennaapp.request.MisSharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarPerfilViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<DuenioEvento> duenioEvento;
    private MisSharedPreferences preferencias;

    public EditarPerfilViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<DuenioEvento> getDuenioEventoLiveData(){
        if(duenioEvento==null){
            duenioEvento = new MutableLiveData<>();
        }
        return duenioEvento;
    }

    public void salir(){

        preferencias.cerrarSesion(context);

    }

    public void getUsuario() {

        String token = preferencias.getToken(context);

        Call<DuenioEvento> duenioEventoCall = ApiClient.getMyApiInterface().logeado("Bearer "+token);
        duenioEventoCall.enqueue(new Callback<DuenioEvento>() {
            @Override
            public void onResponse(Call<DuenioEvento> call, Response<DuenioEvento> response) {
                if(response.isSuccessful()){
                    DuenioEvento duenioLogeado=response.body();
                    duenioEvento.postValue(duenioLogeado);
                } else {
                    duenioEvento.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<DuenioEvento> call, Throwable t) {
                duenioEvento.postValue(null);
            }
        });


    }

    public void guardarDuenio(DuenioEvento duenioLogeado) {
        String token = preferencias.getToken(context);
        DuenioEvento duenioLog = preferencias.getDuenioEvento(context);

        Call<DuenioEvento> duenioEventoCall = ApiClient.getMyApiInterface().guardar("Bearer "+token,
                duenioLog.getIdDuenioEvento(),
                duenioLogeado.getNombre(),
                duenioLogeado.getApellido(),
                duenioLog.getCorreo(),
                duenioLogeado.getClave(),1);
        duenioEventoCall.enqueue(new Callback<DuenioEvento>() {
            @Override
            public void onResponse(Call<DuenioEvento> call, Response<DuenioEvento> response) {
                if(response.isSuccessful()){
                    DuenioEvento duenioLogeado=response.body();
                    duenioEvento.postValue(duenioLogeado);
                    preferencias.guardar(context,duenioLogeado);
                    Toast.makeText(context, "Datos guardados con exito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, response.message()+"", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DuenioEvento> call, Throwable t) {
                Toast.makeText(context, "Error.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void darDeBaja() {
        String token = preferencias.getToken(context);
        DuenioEvento duenioLog = preferencias.getDuenioEvento(context);

        Call<DuenioEvento> duenioEventoCall = ApiClient.getMyApiInterface().darDeBaja("Bearer "+token, duenioLog.getIdDuenioEvento());
        duenioEventoCall.enqueue(new Callback<DuenioEvento>() {
            @Override
            public void onResponse(Call<DuenioEvento> call, Response<DuenioEvento> response) {
                Toast.makeText(context, "exito", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DuenioEvento> call, Throwable t) {
                duenioEvento.postValue(null);
            }
        });
    }


}
