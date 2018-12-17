package de.markusressel.commons.android.core


import android.os.AsyncTask
import android.os.Handler
import android.os.Looper

/**
 * Run a function in an AsyncTask
 *
 * @param handler the function to execute asynchronously
 */
fun Any.doAsync(handler: () -> Unit) {
    object : AsyncTask<Void, Void, Void?>() {
        override fun doInBackground(vararg p0: Void?): Void? {
            handler()
            return null
        }
    }.execute()
}

/**
 * Run a function on the main thread
 *
 * @param action the function to execute
 */
fun runOnUiThread(action: () -> Unit) {
    if (isMainLooperAlive()) {
        action()
    } else {
        Handler(Looper.getMainLooper())
            .post(Runnable(action))
    }
}

/**
 * Run a delayed action
 *
 * @param delayMillis delay in milliseconds
 * @param action the function to execute after the delay
 */
fun runDelayed(delayMillis: Long, action: () -> Unit) = Handler().postDelayed(Runnable(action), delayMillis)

/**
 * Run a delayed action on the main thread
 *
 * @param delayMillis delay in milliseconds
 * @param action the function to execute after the delay
 */
fun runDelayedOnUiThread(delayMillis: Long, action: () -> Unit) =
    Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)

private fun isMainLooperAlive() = Looper.myLooper() == Looper.getMainLooper()