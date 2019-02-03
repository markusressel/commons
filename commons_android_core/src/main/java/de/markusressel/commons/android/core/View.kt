package de.markusressel.commons.android.core

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.view.View

/**
 * Renders a view to a bitmap
 *
 * @param dimensionLimit the maximum image dimension
 * @param backgroundColor background color in case the view doesn't have one
 * @return the rendered image or null if the view has no measured dimensions (yet)
 */
fun View.createSnapshot(dimensionLimit: Float = Float.NaN, backgroundColor: Int = Color.TRANSPARENT): Bitmap? {
    if (measuredWidth == 0 || measuredHeight == 0) {
        return null
    }

    val scaleFactor = if (dimensionLimit.isNaN()) {
        1F // do not scale
    } else {
        // select smaller scaling factor to match dimensionLimit
        Math.min(
            Math.min(
                dimensionLimit / measuredWidth,
                dimensionLimit / measuredHeight
            ),
            1F
        )
    }

    // Define a bitmap with the target dimensions
    val returnedBitmap = Bitmap.createBitmap(
        (this.measuredWidth * scaleFactor).toInt(),
        (this.measuredHeight * scaleFactor).toInt(),
        Bitmap.Config.ARGB_8888
    )

    // bind a canvas to the bitmap
    Canvas(returnedBitmap).apply {
        scale(scaleFactor, scaleFactor)
        drawColor(backgroundColor)
        background?.draw(this)
        draw(this)
    }

    return returnedBitmap
}
