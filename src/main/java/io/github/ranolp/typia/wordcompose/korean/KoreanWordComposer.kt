package io.github.ranolp.typia.wordcompose.korean

import io.github.ranolp.typia.util.H2
import io.github.ranolp.typia.util.isCoda
import io.github.ranolp.typia.util.isH2Part
import io.github.ranolp.typia.util.isNucleus
import io.github.ranolp.typia.util.isOnset
import io.github.ranolp.typia.util.toH2Coda
import io.github.ranolp.typia.util.toH2Onset
import io.github.ranolp.typia.util.toH3Coda
import io.github.ranolp.typia.util.toH3Nucleus
import io.github.ranolp.typia.util.toH3Onset
import io.github.ranolp.typia.wordcompose.SimpleWord
import io.github.ranolp.typia.wordcompose.Word
import io.github.ranolp.typia.wordcompose.WordComposer
import io.github.ranolp.typia.wordcompose.WordComposingTable
import java.text.Normalizer


class KoreanWordComposer(private val useFillers: Boolean, mode: ComposeMode) : WordComposer(
        mode.table
) {

    enum class ComposeMode(internal val table: WordComposingTable, internal val moachigi: Boolean) {
        DUBEOL_STANDARD(KoreanWordComposer.DUBEOL_STANDARD, false),
        DUBEOL_EXTENDED(KoreanWordComposer.DUBEOL_STANDARD, true)
    }

    private inner class HangeulWord : Word() {
        var onset: Char? = null
        var nucleus: Char? = null
        var coda: Char? = null

        internal fun canReceive(c: Char): Boolean {
            TODO()
        }

        override fun generate(): String {
            return Normalizer.normalize("" + (onset ?: "") + (nucleus ?: "") + (coda ?: ""), Normalizer.Form.NFC)
        }

        override fun backspace(): Boolean {
            when {
                coda != null -> coda = null
                nucleus != null -> nucleus = null
                else -> {
                    onset = null
                    words -= this
                    return true
                }
            }
            return false
        }
    }

    private val moachigi: Boolean = mode.moachigi

    override fun input(c: Char) {
        if (isH2Part(c)) {
            val lastWord = lastWord
            if (lastWord is HangeulWord) {
                if (isOnset(c)) {
                    val onset = toH3Onset(c)
                    val lOnset = lastWord.onset
                    if (lOnset != null) {
                        if (lastWord.nucleus == null) {
                            table.tryCompose("${toH2Onset(lOnset)}$c")?.also {
                                lastWord.onset = toH3Onset(it[0])
                            } ?: words.add(HangeulWord().also {
                                it.onset = onset
                            })
                        } else if (isCoda(c)) {
                            if (lastWord.coda == null) {
                                lastWord.coda = toH3Coda(c)
                            } else {
                                words += HangeulWord().also {
                                    it.onset = onset
                                }
                            }
                        }
                    } else if (lastWord.nucleus != null) {
                        if (moachigi) {
                            lastWord.onset = onset
                        } else {
                            words += HangeulWord().also {
                                it.onset = onset
                            }
                        }
                    }
                } else if (isNucleus(c)) {
                    val nucleus = toH3Nucleus(c)
                    val lastCoda = lastWord.coda
                    if (lastWord.onset != null && lastWord.nucleus == null) {
                        lastWord.nucleus = nucleus
                    } else {
                        words += HangeulWord().also {
                            if (lastCoda != null) {
                                it.onset = toH3Onset(toH2Coda(lastCoda))
                            }
                            it.nucleus = nucleus
                        }
                        lastWord.coda = null
                    }
                } else {
                    val onset = toH3Onset(c)
                }
            } else {
                words += HangeulWord().also {
                    when {
                        isOnset(c) -> it.onset = toH3Onset(c)
                        isNucleus(c) -> it.nucleus = toH3Nucleus(c)
                        else -> it.coda = toH3Coda(c)
                    }
                }
            }
        } else {
            words += SimpleWord(c)
        }
    }

    override fun backspace() {
        TODO()
    }

    override fun complete(): Set<String> {
        TODO()
    }

    companion object {

        private val DUBEOL_STANDARD: WordComposingTable

        init {
            val dubeolStandardTable = mapOf(
                    Pair("" + H2.G + H2.S, "" + H2.GS),
                    Pair("" + H2.N + H2.J, "" + H2.NJ),
                    Pair("" + H2.N + H2.H, "" + H2.NH),

                    Pair("" + H2.R + H2.G, "" + H2.RG),
                    Pair("" + H2.R + H2.M, "" + H2.RM),
                    Pair("" + H2.R + H2.B, "" + H2.RB),
                    Pair("" + H2.R + H2.S, "" + H2.RS),
                    Pair("" + H2.R + H2.T, "" + H2.RT),
                    Pair("" + H2.R + H2.P, "" + H2.RP),
                    Pair("" + H2.R + H2.H, "" + H2.RH),

                    Pair("" + H2.B + H2.S, "" + H2.BS),


                    Pair("" + H2.O + H2.A, "" + H2.WA),
                    Pair("" + H2.O + H2.AE, "" + H2.WAE),
                    Pair("" + H2.O + H2.I, "" + H2.OE),

                    Pair("" + H2.U + H2.EO, "" + H2.WO),
                    Pair("" + H2.U + H2.E, "" + H2.WE),
                    Pair("" + H2.U + H2.I, "" + H2.WI),

                    Pair("" + H2.EU + H2.I, "" + H2.UI)
            )

            DUBEOL_STANDARD = WordComposingTable(dubeolStandardTable)
        }
    }
}
