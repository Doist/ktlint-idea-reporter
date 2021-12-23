package com.doist.ktlint.reporter

import com.pinterest.ktlint.core.ReporterProvider
import java.io.PrintStream

@Suppress("unused")
class IdeaReporterProvider : ReporterProvider {
    override val id: String = "idea"

    override fun get(out: PrintStream, opt: Map<String, String>) = IdeaReporter(out)
}
