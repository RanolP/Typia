package io.github.ranolp.typia.wordcompose

abstract class Word {
    var isSelected = false
        private set

    fun select() {
        this.isSelected = true
    }

    fun unselect() {
        this.isSelected = false
    }

    abstract fun generate(): String

    /**
     * Send backspace action to this word
     * @return is word deleted
     */
    abstract fun backspace(): Boolean
}

class SimpleWord(val c: Char) : Word() {
    override fun generate(): String {
        return "$c"
    }

    override fun backspace(): Boolean {
        return true
    }
}
