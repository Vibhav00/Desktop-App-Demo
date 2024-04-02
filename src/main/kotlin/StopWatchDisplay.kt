import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StopWatchDisplay(
    formattedTime: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(1.dp, Color.Blue),
        elevation = 10.dp,
        modifier = Modifier.wrapContentWidth().then(modifier),
        shape = RoundedCornerShape(30.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp, 30.dp).then(modifier),
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                text = formattedTime,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentWidth()
            ) {
                OutlinedButton(onStartClick, shape = RoundedCornerShape(10.dp)) {
                    Text("Start")
                }
                Spacer(Modifier.width(16.dp))
                OutlinedButton(onPauseClick, shape = RoundedCornerShape(10.dp)) {
                    Text("Pause")
                }
                Spacer(Modifier.width(16.dp))
                OutlinedButton(onResetClick, shape = RoundedCornerShape(10.dp)) {
                    Text("Reset")
                }
            }
        }


    }
}

