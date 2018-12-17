package de.markusressel.commons.android.material

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Creates and instantly shows a toast message
 *
 * @param text the toast message
 * @param duration the length to show the toast, one of Toast.LENGTH_SHORT, Toast.LENGTH_LONG
 */
fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

/**
 * Creates and instantly shows a toast message
 *
 * @param text the toast message
 * @param duration the length to show the toast, one of Toast.LENGTH_SHORT, Toast.LENGTH_LONG
 */
fun Context.toast(@StringRes text: Int, duration: Int = Toast.LENGTH_SHORT) {
    toast(this.getString(text), duration)
}