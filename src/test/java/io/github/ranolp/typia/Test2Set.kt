package io.github.ranolp.typia

import io.github.ranolp.typia.keyboard.korean.set2.DubeolExtendedKeyboard
import io.github.ranolp.typia.keyboard.korean.set2.DubeolKeyboard
import org.junit.jupiter.api.Test


class Test2Set {
    @Test
    fun test2Set() {
        val dubeolsik = DubeolExtendedKeyboard(false)

        dubeolsik.shiftKeyDown()
        dubeolsik.keyPress(DubeolKeyboard.Keys.R)
        dubeolsik.shiftKeyUp()
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.I)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.K)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.D)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.R)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.COMMA)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.SPACE)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.Q)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.N)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.F)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.D)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.L)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.D)
        println(dubeolsik.text)
        dubeolsik.keyPress(DubeolKeyboard.Keys.I)
        println(dubeolsik.text)
        dubeolsik.shiftKeyDown()
        dubeolsik.keyPress(DubeolKeyboard.Keys.NUM1)
        dubeolsik.shiftKeyUp()
        println(dubeolsik.text)
    }
}
