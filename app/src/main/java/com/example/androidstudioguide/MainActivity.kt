package com.example.androidstudioguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.androidstudioguide.ui.theme.AndroidStudioGuideTheme

class MainActivity : ComponentActivity() {
    private val viewModal by viewModels<LoginViewModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val kermitDrawable = resources.getDrawable(R.drawable.kermit, null)
        enableEdgeToEdge()
        setContent {
            AndroidStudioGuideTheme {
                Image(painter = painterResource(id = R.drawable.kermit),
                      contentDescription = "Kermit the Frog",
                      modifier = Modifier.fillMaxWidth())
//               Surface(modifier = Modifier.fillMaxSize(), color = viewModal.backgroundColor){
//                    Button(onClick = { viewModal.changeBackgroundColor() }) {
//                        Text(text = "Change Color")
//                    }
//                }
            }
        }
    }
}