package de.markusressel.commons.android.material

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Creates and instantly shows a toast message
 *
 * @param text the toast message
 * @param duration the length to show the toast, one of Toast.LENGTH_SHORT, Toast.LENGTH_LONG
 * @return the toast instance
 */
fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT): Toast {
    val toast = Toast.makeText(this, text, duration)
    toast.show()
    return toast
}

/**
 * Creates and instantly shows a toast message
 *
 * @param text the toast message
 * @param duration the length to show the toast, one of Toast.LENGTH_SHORT, Toast.LENGTH_LONG
 * @return the toast instance
 */
fun Context.toast(@StringRes text: Int, duration: Int = Toast.LENGTH_SHORT): Toast {
    return toast(this.getString(text), duration)
}