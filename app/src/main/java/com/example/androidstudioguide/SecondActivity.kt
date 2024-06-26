package com.example.androidstudioguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.androidstudioguide.ui.theme.AndroidStudioGuideTheme

class SecondActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AndroidStudioGuideTheme {
                Text(text = "Second Activity")
            }
        }
    }
}