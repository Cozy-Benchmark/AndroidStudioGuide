package com.example.androidstudioguide

import android.content.Intent
import android.content.IntentFilter
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
import coil.compose.AsyncImage
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
//        registerReceiver(
//            testReceiver,
//            IntentFilter("Test_Action")
//        )
        setContent {
            AndroidStudioGuideTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    viewModal.uri?.let {
                        AsyncImage(model = viewModal.uri, contentDescription = null)
                    }
                    Button(onClick = {
                        sendBroadcast(
                            Intent("Test_Action")
                        )
                    }) {
//                        Explicit Intent:
//                        Intent to Launch our own activity
//                        Intent(applicationContext, SecondActivity::class.java).also {
//                            startActivity(it)
//                        }
//                        Intent to Launch Activity outside of our own app - Youtube
//                        Intent(Intent.ACTION_MAIN).also {
//                            it.`package` = "com.google.android.youtube"
//                            try {
//                                startActivity(it)
//                            } catch (e : ActivityNotFoundException){
//                                e.printStackTrace()
//                            }
//                        }
//                        Implicit Intent:
//                        val intent = Intent(Intent.ACTION_SEND).apply {
//                            type = "text/plain"
//                            putExtra(Intent.EXTRA_EMAIL, arrayOf("test@test.com"))
//                            putExtra(Intent.EXTRA_SUBJECT, "This is my Subject")
//                            putExtra(Intent.EXTRA_TEXT, "This is the content of my email.")
//                        }
//                        if(intent.resolveActivity(packageManager) != null){
//                            startActivity(intent)
//                        }
//                    }) {
//                        Text(text = "Click!")
//                    }
                        Text(text = "Send Broadcast")
//                Image(painter = painterResource(id = R.drawable.kermit),
//                      contentDescription = "Kermit the Frog",
//                      modifier = Modifier.fillMaxWidth())
//               Surface(modifier = Modifier.fillMaxSize(), color = viewModal.backgroundColor){
//                    Button(onClick = { viewModal.changeBackgroundColor() }) {
//                        Text(text = "Change Color")
//                    }
//                }
                    }
                }
            }
    }

//    override fun onNewIntent(intent: Intent) {
//        super.onNewIntent(intent)
//        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
//        } else {
//            intent.getParcelableExtra(Intent.EXTRA_STREAM)
//        }
//
//        viewModal.updateUri(uri)
    }
    override fun onDestroy(){
        super.onDestroy()
        unregisterReceiver(airPlaneModeReceiver)
//        unregisterReceiver(testReceiver)
    }
}