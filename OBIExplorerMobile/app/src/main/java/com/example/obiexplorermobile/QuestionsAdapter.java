package com.example.obiexplorermobile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    private final Context context;

    public QuestionsAdapter(Context context, List<Questao> questoes) {
        this.context = context;
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

        holder.titulo.setText(
            String.format("%s - %s - %s",
                        questao.getTitulo(), questao.getAno(), questao.getFase())
        );

        holder.enunciado.setText(questao.getEnunciado());
        holder.detalhes.setText(
            String.format("Modalidade: %s, Dificuldade: %s", questao.getModalidade(), questao.getDificuldade())
        );

        boolean isExpanded = position == expandedPosition;
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> {
            expandedPosition = isExpanded ? -1 : position;
            notifyDataSetChanged();
        });

        holder.link.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(questao.getLink()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return questoes.size();
    }

    static class QuestaoViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, enunciado, detalhes, link;
        View expandableLayout;

        public QuestaoViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            enunciado = itemView.findViewById(R.id.enunciado);
            detalhes = itemView.findViewById(R.id.detalhes);
            link = itemView.findViewById(R.id.link);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
        }
    }
}
