package com.example.androidstudioguide

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.example.androidstudioguide.ui.theme.AndroidStudioGuideTheme

class MainActivity : ComponentActivity() {
    private val viewModal by viewModels<ImageViewModel>()
    private val airPlaneModeReceiver = AirPlaneModeReceiver()
    private val testReceiver = TestReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        registerReceiver(
            airPlaneModeReceiver, // Dynamic Broadcasting Receiver - Activates when app is open
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }
        setContent {
            AndroidStudioGuideTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        Intent(applicationContext, RunningServices::class.java).also {
                            it.action = RunningServices.Actions.START.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "Start Run!")
                    }
                    Button(onClick = {
                        Intent(applicationContext, RunningServices::class.java).also {
                            it.action = RunningServices.Actions.STOP.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "Stop Run")
                    }
                }
            }
        }
    }
    override fun onDestroy(){
        super.onDestroy()
        unregisterReceiver(airPlaneModeReceiver)
    }
}