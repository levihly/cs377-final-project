package com.nau.releasefinder.network


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscogsApi {

    @GET("lookup.php")
    fun getMealDetails(@Query("i") id: String) : Call<MealList>

    @GET("filter.php")
    fun getHomeMeals(@Query("c") categoryName: String) : Call<CategoryList>

    @GET("search.php")
    fun searchMeals(@Query("s") searchQuery: String) : Call<MealList>
}