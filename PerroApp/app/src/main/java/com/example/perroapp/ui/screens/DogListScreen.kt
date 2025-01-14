package com.example.perroapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.perroapp.viewmodel.DogViewModel
import com.example.perroapp.model.Dog

@Composable
fun DogListScreen(dogViewModel: DogViewModel) {
    // Obtener la lista de perros desde el ViewModel
    val dogs = dogViewModel.dogs

    // Mostrar la lista de perros en una LazyColumn
    Text(dogs.toString())
//    dogs.map { dog ->
//        Text(dog.name)
////        DogCard(dog)
//    }

}
@Composable
fun DogCard(dog: Dog) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = dog.image?.url,
                contentDescription = "Image of ${dog.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${dog.name}")
            Text(text = "Breed Group: ${dog.breed ?: "Unknown"}")
        }
    }
}
