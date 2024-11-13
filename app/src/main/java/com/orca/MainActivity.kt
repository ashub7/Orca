package com.orca

import HomeScreen
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.orca.design.theme.OrcaTheme
import com.orca.navigation.AppNavHost
import com.orca.navigation.rememberAppState
import com.orca.ui.MainApp
import kotlinx.coroutines.runBlocking
import java.util.Locale
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
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        MainApp(appState = rememberAppState())
                    }
                }
            }
        }
    }

  /*  override fun attachBaseContext(base: Context?) {
        //val locale = runBlocking { MantaApp.INSTANCE.dataStoreRepo.dataStore.data.first() }[DataStoreRepo.SELECTED_LOCALE]?:"en"
        val locale = "en"
        super.attachBaseContext(applyNewLocale(Locale(locale)))
    }*/

    private fun applyNewLocale(locale: Locale): Context {
        val config = this.resources.configuration
        val sysLocale = config.locales.get(0)
        if (sysLocale.language != locale.language) {
            Locale.setDefault(locale)
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
        return this
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