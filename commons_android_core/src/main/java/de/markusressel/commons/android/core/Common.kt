package de.markusressel.commons.android.core

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater

/**
 * Create a layout inflater from this context
 */
fun Context.layoutInflater(): LayoutInflater {
    return LayoutInflater.from(this)
}

/**
 * Computes a URL for a resource file
 * @param context application context
 * @param resID file resource
 */
fun resourceToURL(context: Context, resID: Int): String {
    val scheme = ContentResolver.SCHEME_ANDROID_RESOURCE
    val packageName = context.resources.getResourcePackageName(resID)
    val typeName = context.resources.getResourceTypeName(resID)
    val entryName = context.resources.getResourceEntryName(resID)

    return "$scheme://$packageName/$typeName/$entryName"
}

/**
 * Computes the URI for a resource file
 *
 * @param context application context
 * @param resID file resource
 */
fun resourceToUri(context: Context, resID: Int): Uri {
    return Uri.parse(resourceToURL(context, resID))
}