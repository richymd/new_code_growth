package com.richymd.gadsleaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.richymd.gadsleaderboard.data.SkillIq;
import com.richymd.gadsleaderboard.services.ApiClient;
import com.richymd.gadsleaderboard.services.ServiceApiInterface;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SkillFragment() {

    }

    public static SkillFragment newInstance(String param1, String param2) {
        SkillFragment fragment = new SkillFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_learning, container, false);

        final ProgressBar progressBar = rootView.findViewById(R.id.progressBar);

        final RecyclerView skillList =  rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        skillList.setLayoutManager(layoutManager);


        ServiceApiInterface serviceApiInterface = ApiClient.buildApiService(ServiceApiInterface.class);
        Call<ArrayList<SkillIq>> topSkillsIQRequest = serviceApiInterface.getTopSkillIqScores();

        topSkillsIQRequest.enqueue(new Callback<ArrayList<SkillIq>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<SkillIq>> call, @NotNull Response<ArrayList<SkillIq>> response) {
                SkillRecyclerAdapter skillRecyclerAdapter = new SkillRecyclerAdapter(getActivity(), response.body());
                progressBar.setVisibility(View.GONE);
                skillList.setAdapter(skillRecyclerAdapter);
            }

            @Override
            public void onFailure(@NotNull Call<ArrayList<SkillIq>> call, @NotNull Throwable t) {
                Toast.makeText(getContext(), "Failed to Retrieve Learners", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}