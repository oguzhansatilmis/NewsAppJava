package com.test.newsappjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.test.newsappjava.databinding.FragmentNewsDetailBinding;

import java.util.Objects;


public class NewsDetailFragment extends Fragment {

    private FragmentNewsDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentNewsDetailBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String newsImageUrl = bundle.getString("newsImageUrl");
            String newsTitle = bundle.getString("newsTitle");
            String newsDescription = bundle.getString("newsDescription");

            Glide.with(requireContext()).load(newsImageUrl).into(binding.newsImage);
            binding.newsDetail.setText(newsDescription);
            binding.newsTitle.setText(newsTitle);

        }
        else {
            System.out.println("null geldi");
        }


    }
}