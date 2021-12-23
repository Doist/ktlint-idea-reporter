package com.doist.ktlint.reporter

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.core.Reporter
import java.io.PrintStream

/**
 * This reporter improves ktlint output for better integration with IntelliJ IDEA based IDE.
 */
class IdeaReporter(private val out: PrintStream) : Reporter {
    override fun onLintError(file: String, err: LintError, corrected: Boolean) {
        out.println("e: $file: (${err.line}, ${err.col}): ${err.detail}")
    }
}
