package de.markusressel.commons.logging

/**
 * @return a pretty printed version of this throwable
 */
fun Throwable.prettyPrint(): String {
    return "${this.message}:\n" + "${stackTrace.joinToString(separator = "\n")}}"
}