package com.example.obiexplorermobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.obiexplorermobile.dto.Questao;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestaoViewHolder> {

    private final List<Questao> questoes;
    private int expandedPosition = -1;

    public QuestionsAdapter(List<Questao> questoes) {
        this.questoes = questoes;
    }

    @NonNull
    @Override
    public QuestaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_questao, parent, false);
        return new QuestaoViewHolder(view);
    }

    public void atualizarQuestoes(List<Questao> novasQuestoes) {
        questoes.clear();
        questoes.addAll(novasQuestoes);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NonNull QuestaoViewHolder holder, int position) {
        Questao questao = questoes.get(position);

        // Configurar o título
        holder.titulo.setText(
            String.format("%s - %s - %s",
                        questao.getTitulo(), questao.getAno(), questao.getFase())
        );

        // Configurar os detalhes
        holder.enunciado.setText(questao.getEnunciado());
        holder.detalhes.setText(
            String.format("Modalidade: %s, Dificuldade: %s", questao.getModalidade(), questao.getDificuldade())
        );

        // Gerenciar visibilidade da seção expansível
        boolean isExpanded = position == expandedPosition;
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> {
            expandedPosition = isExpanded ? -1 : position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return questoes.size();
    }

    static class QuestaoViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, enunciado, detalhes;
        View expandableLayout;

        public QuestaoViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            enunciado = itemView.findViewById(R.id.enunciado);
            detalhes = itemView.findViewById(R.id.detalhes);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
        }
    }
}
