package de.markusressel.commons.logging

/**
 * @return a pretty printed version of this throwable
 */
fun Throwable.prettyPrint(): String {
    return "${this.message}:\n" + "${stackTrace.joinToString(separator = "\n")}}"
}

/**
 * Create a logger TAG
 */
fun Any.createLoggingTag(): String = this.javaClass.simpleName.slice(0..23)