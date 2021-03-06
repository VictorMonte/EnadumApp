package br.com.navi.enadumapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.Adapter.FragmentPageAdapter;
import br.com.navi.enadumapp.Utils.AlertManager;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.Curso;

public class HomeActivity extends AppCompatActivity {

    private Aluno aluno;
    private TabLayout tab;
    private ViewPager view;
    private TextView lblAluno;
    private TextView lblCurso;
    private TextView lblInstituicao;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        aluno = SessionRepository.aluno;

        //Obtem componentes
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tab = (TabLayout) findViewById(R.id.tab_principal);
        view = (ViewPager) findViewById(R.id.view_pager);
        lblAluno = (TextView) findViewById(R.id.lblAluno);
        lblCurso = (TextView) findViewById(R.id.lblCurso);
        lblInstituicao = (TextView) findViewById(R.id.lblInstituicao);

        setSupportActionBar(toolbar);

        //Configura as tabs
        view.setAdapter(new FragmentPageAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titulos_tab)));

        //Configura a view
        tab.setupWithViewPager(view);

        //Valida usuario
        if (aluno == null) {
            AlertManager.Alertar(
                    HomeActivity.this,
                    "Erro: Dados do usuário inválidos",
                    new Intent(HomeActivity.this, LoginActivity.class));
        }
        else{
            //Mostra os dados do aluno
            lblAluno.setText("Bem vindo, " + aluno.getNome());
            lblInstituicao.setText(aluno.getInstituicao().getNome());

            String txtCursos = "";
            List<Curso> cursos = aluno.getCursos();
            int i = 0;
            for(Curso curso : cursos){
                txtCursos += curso.getNome();
                if(i != cursos.size() -1){
                    txtCursos += "\n";
                }
            }
            lblCurso.setText(txtCursos);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "MITOR SERMITOR", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }
}
