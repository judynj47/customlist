package com.example.customlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customlistapp.ui.theme.CustomListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myFunction()
                   
                }
            }
        }
    }
}
@Composable
fun myFunction() {
    data class SchoolModel(val name: String, val image: Int)
    @Composable
    fun ListRow(model: SchoolModel) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = model.image), contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
            Text(
                text = model.name,
                fontSize = 20.sp,
                color = Color.Blue
            )
        }

        val schoolList = mutableListOf<SchoolModel>()

        schoolList.add(SchoolModel("Pic 1", R.drawable.codeschool1))
        schoolList.add(SchoolModel("Pic 2", R.drawable.codeschool2))
        schoolList.add(SchoolModel("Pic 3", R.drawable.codeschool7))
        schoolList.add(SchoolModel("Pic 4", R.drawable.codeschool8))
        schoolList.add(SchoolModel("Pic 5", R.drawable.codeschool9))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            items(schoolList) { model ->
                ListRow(model = model)
            }
        }
    }

}
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CustomListAppTheme {
            myFunction()
        }
    }