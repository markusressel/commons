package de.markusressel.commons.random

import java.util.*

/**
 * @return a random number within the given range
 */
fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start