package br.com.navi.enadumapp.Controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import br.com.navi.enadumapp.HomeActivity;
import br.com.navi.enadumapp.LoginActivity;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.API.HttpAPI;
import br.com.navi.enadumapp.models.API.ServiceGenerator;
import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.SimuladoEnade;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Danilo on 17/09/2016.
 */

public class LoginController {

    LoginActivity activity;
    Context context;

    public LoginController(Context context){
        this.context = context;
    }

    public void login(final LoginRequest loginRequest){

        Log.d("logLevel", "called loginController");
        final ProgressDialog mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        HttpAPI api = ServiceGenerator.createService(HttpAPI.class);
        Call<Aluno> call = api.getAluno(loginRequest);
        call.enqueue(new Callback<Aluno>() {

            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                Log.d("LogLevel", "onResponse is called");
                Log.d("Status", "OK");
                if (response.isSuccessful()) {
                    Log.d("Status", "Response raw(): " + response.raw());
                    Log.d("Status", "Response body(): " + response.body());
                    SessionRepository.loginRequest = loginRequest;
                    SessionRepository.aluno = response.body();


                    context.startActivity(new Intent(context, HomeActivity.class));


                    if (mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }

                } else {
                    Log.d("Status", "message: " + response.message());
                    Log.d("Status", "body: " + response.errorBody());
                    Log.d("Status", "raw: " + response.raw());
                    Log.d("Status", "Response NOT OK");

                    if (mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Log.d("Status", "FAIL: " + t.getMessage());

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
            }
        });

    }
}
