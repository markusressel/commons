package de.markusressel.commons.android.themes

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat

/**
 * Get Color from Theme attribute
 *
 * @param context Activity context
 * @param attr    Attribute ressource ID
 *
 * @return Color as Int
 */
@ColorInt
fun Context.getThemeAttrColor(@AttrRes attr: Int, @ColorInt default: Int = 0): Int {
    val typedValue = TypedValue()
    if (this.theme.resolveAttribute(attr, typedValue, true)) {
        if (typedValue.type >= TypedValue.TYPE_FIRST_INT && typedValue.type <= TypedValue.TYPE_LAST_INT) {
            return typedValue.data
        } else if (typedValue.type == TypedValue.TYPE_STRING) {
            return ContextCompat.getColor(this, typedValue.resourceId)
        }
    }

    return default
}

/**
 * Apply a theme to an activity
 *
 * @param activity the activity to apply the theme to
 * @param themeRes theme resource
 */
fun Activity.applyTheme(@StyleRes themeRes: Int) {
    this.applicationContext.setTheme(themeRes)
    this.setTheme(themeRes)
}