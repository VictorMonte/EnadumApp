package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Danilo on 17/09/2016.
 */
public class CursoMEC {

    @SerializedName("id")
    private Integer id;

    @SerializedName("idMec")
    private String idMec;

    @SerializedName("simuladosEnade")
    private List<SimuladoEnade> simuladosEnade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdMec() {
        return idMec;
    }

    public void setIdMec(String idMec) {
        this.idMec = idMec;
    }

    public List<SimuladoEnade> getSimuladosEnade() {
        return simuladosEnade;
    }

    public void setSimuladosEnade(List<SimuladoEnade> simuladosEnade) {
        this.simuladosEnade = simuladosEnade;
    }
}
