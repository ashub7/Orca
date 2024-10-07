package com.orca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.orca.design.theme.OrcaTheme
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    companion object {
        private const val SPLASH_DURATION = 3_000L
    }

    private var splashEndTime by Delegates.notNull<Long>()
    override fun onCreate(savedInstanceState: Bundle?) {
        splashEndTime = System.currentTimeMillis() + SPLASH_DURATION
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashEndTime >= System.currentTimeMillis()
            }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrcaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OrcaTheme {
        Greeting("Android")
    }
}