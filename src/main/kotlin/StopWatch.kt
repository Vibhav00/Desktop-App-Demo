import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

class StopWatch {
    /** formatted time state  **/
    var formattedTime by mutableStateOf("00:00:000")


    /** Coroutine scope for main thread  **/
    private var coroutineScope = CoroutineScope(Dispatchers.Main)

    /** if the timer is active , isActive is true  **/
    private var isActive = false

    /** handling timeMillies  **/
    private var timeMillis = 0L
    private var lastTimestamp = 0L


    /** function to start the timer  **/
    fun start() {
        if (isActive) return
        coroutineScope.launch {
            lastTimestamp = System.currentTimeMillis()
            this@StopWatch.isActive = true
            while (this@StopWatch.isActive) {
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimestamp
                lastTimestamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)

            }

        }
    }


    /** function to pause the animation  **/
    fun pause() {
        isActive = false
    }


    /** function to reset the timer  **/
    fun reset() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        timeMillis = 0L
        lastTimestamp = 0L
        formattedTime = "00:00:000"
        isActive = false
    }


    /** function to format time in mm:ss:SSS  **/
    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeMillis), ZoneId.of("UTC")
        )
        val formatter = DateTimeFormatter.ofPattern("mm:ss:SSS", Locale.getDefault())
        return localDateTime.format(formatter)
        /** same thing can be done by   **/
//        var date = Date(timeMillis)
//        var sdf= SimpleDateFormat("mm:ss:SSS")
//        sdf.timeZone= TimeZone.getTimeZone("UTC")
//        return sdf.format(date)
    }
}
