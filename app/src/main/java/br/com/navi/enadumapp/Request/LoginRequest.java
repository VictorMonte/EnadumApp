package br.com.navi.enadumapp.Request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Danilo on 17/09/2016.
 */

public class LoginRequest {

    @SerializedName("login")
    private String login;

    @SerializedName("cpf")
    private String cpf;

    public LoginRequest(String login, String cpf) {
        this.login = login;
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
