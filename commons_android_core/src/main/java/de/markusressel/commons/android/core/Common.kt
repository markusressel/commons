package de.markusressel.commons.android.core

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater

/**
 * Create a layout inflater from this context
 */
fun Context.layoutInflater(): LayoutInflater {
    return LayoutInflater
        .from(this)
}

/**
 * Computes a URL for a resource file
 * @param context application context
 * @param resID file resource
 */
fun resourceToURL(context: Context, resID: Int): String {
    return ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.resources.getResourcePackageName(resID) + '/'.toString() + context.resources.getResourceTypeName(
        resID
    ) + '/'.toString() + context.resources.getResourceEntryName(resID)
}

/**
 * Computes the URI for a resource file
 *
 * @param context application context
 * @param resID file resource
 */
fun resourceToUri(context: Context, resID: Int): Uri {
    return Uri
        .parse(resourceToURL(context, resID))
}