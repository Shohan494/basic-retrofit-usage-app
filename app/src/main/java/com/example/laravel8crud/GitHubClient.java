package com.example.laravel8crud;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;

public interface GitHubClient {
    @GET("/users/{user}/repos")

    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

    @POST("/users/{user}/repos")

    Call<List<GitHubRepo>> reposForUserPost(@Path("user") String user);
}