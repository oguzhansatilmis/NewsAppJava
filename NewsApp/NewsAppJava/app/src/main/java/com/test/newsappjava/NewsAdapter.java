package com.test.newsappjava;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.test.newsappjava.databinding.NewsitemBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


     List<Article> articleList = new ArrayList<>();
     Context context;


    @Inject
    public NewsAdapter(List<Article> articleList,Context context) {
        this.articleList = articleList;
        this.context = context;

    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NewsitemBinding binding = NewsitemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

        Article article = articleList.get(position);
        holder.binding.newsTitle.setText(article.getTitle());
        holder.binding.newsDescription.setText(article.getDescription());

        holder.binding.newsDescription.setOnClickListener(view -> {

            NewsDetailFragment newsFragment = new NewsDetailFragment();



            Bundle bundle = new Bundle();
            bundle.putString("newsImageUrl", article.getUrlToImage());
            bundle.putString("newsTitle", article.getTitle());
            bundle.putString("newsDescription", article.getDescription());
            newsFragment.setArguments(new Bundle());

            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_newsFragment_to_newsDetailFragment,bundle);


        });

        if (article.getUrl() == null) {
            Log.d("MyTag", "URL is null");
        } else {
            Glide.with(holder.itemView).load(article.getUrlToImage()).into(holder.binding.newsImage);
        }

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
        notifyDataSetChanged(); // Veri değiştiğinde RecyclerView'ı güncelle
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsitemBinding binding;


        public ViewHolder(@NonNull View itemView, NewsitemBinding binding) {

            super(itemView);

            this.binding = binding;
        }
    }
}
