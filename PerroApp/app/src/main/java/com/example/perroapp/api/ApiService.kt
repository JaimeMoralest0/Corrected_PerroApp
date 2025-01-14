
package com.example.perroapp.api

import com.example.perroapp.model.Dog
import retrofit2.http.GET

interface ApiService {
    @GET("breeds")
    suspend fun getBreeds(): List<Dog>
}