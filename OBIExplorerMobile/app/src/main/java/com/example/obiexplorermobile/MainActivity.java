package com.example.obiexplorermobile;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.obiexplorermobile.dto.Questao;
import com.example.obiexplorermobile.dto.SpinnerCallback;
import com.example.obiexplorermobile.dto.SpinnerItem;
import com.example.obiexplorermobile.services.QuestionsService;
import com.example.obiexplorermobile.services.SpinnerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final QuestionsService questionsService = new QuestionsService();

    private EditText titulo;
    private EditText descricao;
    private Spinner spinnerAno;
    private Spinner spinnerNivel;
    private Spinner spinnerModalidade;
    private Spinner spinnerFase;
    private Spinner spinnerCategoria;
    private Spinner spinnerSubcategoria;
    private Spinner spinnerTopico;
    private Spinner spinnerDificuldade;

    private QuestionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinnerService spinnerService = new SpinnerService();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setNestedScrollingEnabled(true);

        adapter = new QuestionsAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        titulo = findViewById(R.id.title);
        descricao = findViewById(R.id.description);
        spinnerAno = findViewById(R.id.spinner_year);
        spinnerNivel = findViewById(R.id.spinner_level);
        spinnerModalidade = findViewById(R.id.spinner_modality);
        spinnerFase = findViewById(R.id.spinner_phase);
        spinnerCategoria = findViewById(R.id.spinner_category);
        spinnerSubcategoria = findViewById(R.id.spinner_subcategory);
        spinnerTopico = findViewById(R.id.spinner_topic);
        spinnerDificuldade = findViewById(R.id.spinner_difficulty);

        spinnerService.fetchList("/testYears", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterAno = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerAno.setAdapter(adapterAno);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerService.fetchList("/level", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterNivel = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterNivel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerNivel.setAdapter(adapterNivel);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerService.fetchList("/modality", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterModalidades = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterModalidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerModalidade.setAdapter(adapterModalidades);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerService.fetchList("/phase", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterFases = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterFases.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFase.setAdapter(adapterFases);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerService.fetchList("/category", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterCategoria = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCategoria.setAdapter(adapterCategoria);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerService.fetchList("/subcategories", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterSubcategoria = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterSubcategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerSubcategoria.setAdapter(adapterSubcategoria);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerService.fetchList("/topics", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterTopico = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterTopico.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTopico.setAdapter(adapterTopico);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerService.fetchList("/difficulty", new SpinnerCallback() {
            @Override
            public void onSuccess(List<SpinnerItem> list) {
                list.add(0, new SpinnerItem("0", "Selecione"));
                ArrayAdapter<SpinnerItem> adapterDificuldades = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
                adapterDificuldades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerDificuldade.setAdapter(adapterDificuldades);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Erro ao carregar Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnBuscar = findViewById(R.id.btn_search);
        btnBuscar.setOnClickListener(v -> searchQuestions());

        Button btnLimpar = findViewById(R.id.btn_clear);
        btnLimpar.setOnClickListener(v -> clearFilters());

    }

    private void searchQuestions() {
        Thread requestThread = new Thread() {
            public void run() {
                String textoTitulo = titulo.getText().toString();
                String textoDescricao = descricao.getText().toString();
                String anoSelecionado = ((SpinnerItem) spinnerAno.getSelectedItem()).getId();
                String nivelSelecionado = ((SpinnerItem) spinnerNivel.getSelectedItem()).getId();
                String modalidadeSelecionado = ((SpinnerItem) spinnerModalidade.getSelectedItem()).getId();
                String faseSelecionado = ((SpinnerItem) spinnerFase.getSelectedItem()).getId();
                String categoriaSelecionado = ((SpinnerItem) spinnerCategoria.getSelectedItem()).getId();
                String subCategoriaSelecionado = ((SpinnerItem) spinnerSubcategoria.getSelectedItem()).getId();
                String topicoSelecionado = ((SpinnerItem) spinnerTopico.getSelectedItem()).getId();
                String dificuldadeSelecionado = ((SpinnerItem) spinnerDificuldade.getSelectedItem()).getId();

                List<Questao> questoes = questionsService.getQuestions(
                        textoTitulo, textoDescricao, anoSelecionado, nivelSelecionado, modalidadeSelecionado, faseSelecionado,
                        categoriaSelecionado, subCategoriaSelecionado, topicoSelecionado, dificuldadeSelecionado
                );

                if (!questoes.isEmpty()) {
                    runOnUiThread(() -> {
                        adapter.atualizarQuestoes(questoes);
                        findViewById(R.id.no_results).setVisibility(View.GONE);
                    });
                } else {
                    runOnUiThread(() -> {
                        findViewById(R.id.no_results).setVisibility(View.VISIBLE);
                        adapter.atualizarQuestoes(new ArrayList<>());
                    });

                }

            }
        };

        requestThread.start();
        Toast.makeText(MainActivity.this, getString(R.string.search_questions), Toast.LENGTH_SHORT).show();
    }

    private void clearFilters() {
        titulo.setText("");
        descricao.setText("");
        spinnerAno.setSelection(0);
        spinnerNivel.setSelection(0);
        spinnerModalidade.setSelection(0);
        spinnerFase.setSelection(0);
        spinnerCategoria.setSelection(0);
        spinnerSubcategoria.setSelection(0);
        spinnerTopico.setSelection(0);
        spinnerDificuldade.setSelection(0);
        Toast.makeText(MainActivity.this, getString(R.string.filtersCleaned), Toast.LENGTH_LONG).show();
    }
}

