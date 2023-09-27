package com.test.newsappjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.newsappjava.databinding.FragmentNewsBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;

    @Inject
    NewsViewModel newsViewModel;

    @Inject
    NewsAdapter newsAdapter; // NewsAdapter'ı enjekte edin

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = binding.newsRecyclerview; // RecyclerView'ı tanımlayın
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext())); // Layout yöneticisini ayarlayın

        recyclerView.setAdapter(newsAdapter);

        newsViewModel.getNewsLiveData().observe(getViewLifecycleOwner(), newsResponse -> {
            List<Article> articleList = newsResponse.getArticles();
            newsAdapter.setArticleList(articleList);
        });
    }
}
