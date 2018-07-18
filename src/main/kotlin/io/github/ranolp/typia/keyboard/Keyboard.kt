package io.github.ranolp.typia.keyboard

import io.github.ranolp.typia.action.Action
import io.github.ranolp.typia.action.KeyDownAction
import io.github.ranolp.typia.action.KeyPressAction
import io.github.ranolp.typia.keyboard.key.Key
import io.github.ranolp.typia.state.ALT
import io.github.ranolp.typia.state.CTRL
import io.github.ranolp.typia.state.SHIFT
import io.github.ranolp.typia.state.State
import io.github.ranolp.typia.wordcompose.WordComposer


abstract class Keyboard(keys: Collection<Key>, protected val wordComposer: WordComposer) {
    private val keys = keys.toSet()

    protected val shift: Boolean
        get() = wordComposer.isStateEnabled(SHIFT)
    protected val alt: Boolean
        get() = wordComposer.isStateEnabled(ALT)
    protected val ctrl: Boolean
        get() = wordComposer.isStateEnabled(CTRL)

    val text: String
        get() = wordComposer.text

    fun getKeys(): Set<Key> {
        return keys
    }

    fun isStateEnabled(state: State): Boolean = wordComposer.isStateEnabled(state)

    fun enableState(state: State) {
        wordComposer.enableState(state)
    }

    fun disableState(state: State) {
        wordComposer.disableState(state)
    }

    fun reverseState(state: State) {
        wordComposer.reverseState(state)
    }

    fun shiftKeyDown() {
        enableState(SHIFT)
    }

    fun shiftKeyUp() {
        disableState(SHIFT)
    }

    fun keyPress(key: Key) {
        handleAction(KeyPressAction(key))
    }

    fun keyDown(key: Key) {
        handleAction(KeyDownAction(key))
    }

    fun keyUp(key: Key) {
        handleAction(KeyDownAction(key))
    }

    abstract fun handleAction(action: Action)
}
