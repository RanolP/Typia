package io.github.ranolp.typia.wordcompose


class WordComposingTable(private val table: Map<String, String>) {

    fun tryCompose(str: String): String? {
        return table[str]
    }

    companion object {
        val EMPTY = WordComposingTable(emptyMap())
    }
}
