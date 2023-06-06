package br.senai.sp.jandira.lionschool

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.ListaCursos
import br.senai.sp.jandira.lionschool.services.RetrofitFactory
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
            LionScoolScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LionScoolScreen() {

    var cursos by remember{
        mutableStateOf(listOf<br.senai.sp.jandira.lionschool.model.Curso>())
    }


    //Chamada para a API
    val call = RetrofitFactory().getCursoService().getCursos()


    call.enqueue(object : Callback<ListaCursos> {
        override fun onResponse(
            call: Call<ListaCursos>,
            response: Response<ListaCursos>
        ) {

        }

        override fun onFailure(call: Call<ListaCursos>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure:")
        }

    })


    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(top = 40.dp)
                )
            }

            Column(
                modifier = Modifier
                    .height(100.dp)
                    .padding(start = 30.dp), verticalArrangement = Arrangement.Center
            ) { // column pai dos texts
                Column() {
                    Text(
                        text = stringResource(id = R.string.title),
                        fontSize = 64.sp,
                        fontWeight = FontWeight(500),
                        color = Color(204, 164, 68, 255)
                    )
                    LazyColumn(){
                        items(cursos){
                            Card(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 8.dp),
                                backgroundColor = Color(79, 79, 79, 255)
                            ) {
                                
                            }
                        }
                    }
                }
            }
        }
    }
}

