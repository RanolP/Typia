package io.github.ranolp.typia.wordcompose

import io.github.ranolp.typia.state.State

abstract class WordComposer(protected val table: WordComposingTable) {
    protected var state: Int = 0
    protected val words: MutableList<Word> = mutableListOf()
    protected val lastWord: Word?
        get() = if (words.isEmpty()) null else words[words.size - 1]

    val text: String
        get() = words.joinToString("") { it.generate() }


    abstract fun input(c: Char)

    abstract fun backspace()

    abstract fun complete(): Set<String>

    fun isStateEnabled(state: State): Boolean = this.state and state.bitId == state.bitId

    fun enableState(state: State) {
        this.state = this.state or state.bitId
    }

    fun disableState(state: State) {
        this.state = this.state and (state.bitId xor this.state)
    }

    fun reverseState(state: State) {
        this.state = this.state xor state.bitId
    }
}
