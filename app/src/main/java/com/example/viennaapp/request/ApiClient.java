package com.example.viennaapp.request;

import com.example.viennaapp.models.Contrato;
import com.example.viennaapp.models.DuenioEvento;
import com.example.viennaapp.models.Evento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiClient {
    private static final String PATH="https://192.168.1.129:45455/api/";
    private static MyApiInterface myApiInterface;


    public static MyApiInterface getMyApiInterface(){

        Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInterface= retrofit.create(MyApiInterface.class);
        return myApiInterface;
    }



    public interface MyApiInterface{

        @POST("DuenioEvento/login")
        Call<String> treaerToken(@Query("Correo")String correo, @Query("Clave")String clave);

        @GET("DuenioEvento")
        Call<DuenioEvento> logeado(@Header("Authorization")String authorizarion);

        @FormUrlEncoded
        @PUT("DuenioEvento/{id}")
        Call<DuenioEvento> guardar(@Header("Authorization")String authorizarion,
                                   @Path("id")int idDuenio,
                                   @Field("Nombre") String nombre,
                                   @Field("Apellido")String apellido,
                                   @Field("Correo") String correo,
                                   @Field("Clave")String clave,
                                   @Field("EstadoDuenio")int estado);

        @DELETE("DuenioEvento/{id}")
        Call<DuenioEvento> darDeBaja(@Header("Authorization")String authorizarion,@Path("id")int idDuenio);

        @GET("Contrato")
        Call<List<Contrato>> traerContratoByDuenio(@Header("Authorization")String authorizarion);

        @GET("Evento")
        Call<List<Evento>> traerEventosByDuenio(@Header("Authorization")String authorizarion);

        @DELETE("Evento/{id}")
        Call<Evento> cancelarEventoByDuenio(@Header("Authorization")String authorizarion,
                                            @Path("id")int id);

        @FormUrlEncoded
        @POST("Evento/{nombreSala}")
        Call<Evento> solicitarEvento(@Header("Authorization")String authorizarion,
                                     @Path("nombreSala")String nombre,
                                     @Field("Nombre")String nombreEvento,
                                     @Field("InicioEvento")String inicioEvento,
                                     @Field("FinEvento")String FinEvento,
                                     @Field("PrecioEntrada")String precio);


    }
}
