package de.markusressel.commons.themes

import android.app.Activity
import android.content.Context
import android.support.annotation.AttrRes
import android.support.annotation.ColorInt
import android.support.annotation.StyleRes
import android.support.v4.content.ContextCompat
import android.util.TypedValue

class ThemeHelper {

    companion object {

        /**
         * Apply a theme to an activity
         *
         * @param activity the activity to apply the theme to
         * @param themeRes theme resource
         */
        fun applyTheme(activity: Activity, @StyleRes themeRes: Int) {
            activity
                .applicationContext
                .setTheme(themeRes)
            activity
                .setTheme(themeRes)
        }

        /**
         * Get Color from Theme attribute
         *
         * @param context Activity context
         * @param attr    Attribute ressource ID
         *
         * @return Color as Int
         */
        @ColorInt
        fun getThemeAttrColor(context: Context, @AttrRes attr: Int): Int {
            val typedValue = TypedValue()
            if (context.theme.resolveAttribute(attr, typedValue, true)) {
                if (typedValue.type >= TypedValue.TYPE_FIRST_INT && typedValue.type <= TypedValue.TYPE_LAST_INT) {
                    return typedValue
                        .data
                } else if (typedValue.type == TypedValue.TYPE_STRING) {
                    return ContextCompat
                        .getColor(context, typedValue.resourceId)
                }
            }

            return 0
        }

    }

}