import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(modifier: Modifier = Modifier){
  Surface {
      Column(
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Center
      ) {
          Text(
              text = "Hello From Login Screen",
              modifier = modifier,
              style = TextStyle(
                  fontSize = 33.sp
              )
          )
      }
  }
}