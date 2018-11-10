package de.markusressel.commons.android.core

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

/**
 * @return this value interpreted as DP and converted to PX
 */
fun Int.dpToPx(): Int {
    return this.toDouble().dpToPx()
}

/**
 * @return this value interpreted as DP and converted to PX
 */
fun Double.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

/**
 * @return this value interpreted as SP and converted to PX
 */
fun Int.spToPx(): Float {
    return this.toFloat().spToPx()
}

/**
 * @return this value interpreted as SP and converted to PX
 */
fun Float.spToPx(): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)
}

/**
 * @return this value interpreted as SP and converted to PX
 */
fun Double.spToPx(): Float {
    return this.toFloat().spToPx()
}

/**
 * @return this value interpreted as PX and converted to SP
 */
fun Float.pxToSp(context: Context): Float {
    return this / context.resources.displayMetrics.scaledDensity
}
