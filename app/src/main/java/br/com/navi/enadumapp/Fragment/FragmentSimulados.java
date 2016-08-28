package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.navi.enadumapp.Model.Disciplina;
import br.com.navi.enadumapp.R;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentSimulados extends Fragment {

    private ListView listViewDisciplinas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layoutSimulados = inflater.inflate(R.layout.fragment_simulados,container,false);

        this.listViewDisciplinas = (ListView) layoutSimulados.findViewById(R.id.lista_simulados_listview);


        //ToDO:Quando tiver conexao com um servidor apagar as linha de baixo e ativar a chamada do metodo que faz a
        // requisicao de todas as disciplinas
        Disciplina disciplina1 = new Disciplina("Banco de Dados I",new Long(1));
        Disciplina disciplina2 = new Disciplina("Tecnicas de Programacao I", new Long(2));

        List<Disciplina> disciplinas = Arrays.asList(disciplina1,disciplina2);

        this.listViewDisciplinas.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, disciplinas));

        this.listViewDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Disciplina selecionada  = (Disciplina) adapterView.getItemAtPosition(i);
                Toast.makeText(getActivity(), "Disciplina selecionada: " +  selecionada, Toast.LENGTH_SHORT).show();
            }
        });

        return layoutSimulados;
    }
}
