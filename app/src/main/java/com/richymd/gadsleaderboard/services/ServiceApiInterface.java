package com.richymd.gadsleaderboard.services;

import com.richymd.gadsleaderboard.data.LearningHours;
import com.richymd.gadsleaderboard.data.SkillIq;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApiInterface {

    @GET("api/hours")
    Call<ArrayList<LearningHours>> getTopLearners();

    @GET("api/skilliq")
    Call<ArrayList<SkillIq>> getTopSkillIqScores();

}
