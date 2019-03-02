package com.anangkur.belajarandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anangkur.belajarandroid.model.Article;
import com.anangkur.belajarandroid.model.RespondAPI;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    private ArrayList<Article> article = new ArrayList<>();

    public MainAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.listitem, viewGroup, false);
        return new ViewHolder(view);
    }
    public void setData(List<Article> article){
        this.article.clear();
        this.article.addAll(article);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(article.get(i));
    }

    @Override
    public int getItemCount() {
        return article.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemlist);
        }
        public void bind(Article article){
            textView.setText(article.getTitle());
        }
    }
}
