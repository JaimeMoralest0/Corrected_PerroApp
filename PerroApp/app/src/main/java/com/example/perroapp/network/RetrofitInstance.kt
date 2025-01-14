package com.example.perroapp.network

import com.example.perroapp.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // Define la URL base de la API
    private const val BASE_URL = "https://api.thedogapi.com/v1/"

    // Cliente HTTP con un interceptor para añadir la API Key a cada solicitud
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("x-api-key", "live_gj61q9nxfmQDMeRfcN8QZtVgJ42Z7nLREoksdDgxZgZcJnvIZYvl06AfyLE7H60H")
            .build()
        chain.proceed(request)
    }.build()

    // Creo la instancia de Retrofit utilizando la URL base y el convertidor de Gson
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // URL base
            .client(client) // Usa el cliente configurado
            .addConverterFactory(GsonConverterFactory.create()) // Convertir JSON a objetos
            .build()
            .create(ApiService::class.java) // Creo la instancia de ApiService
    }
}
