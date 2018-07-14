package io.github.ranolp.typia.keyboard.korean.set2

import io.github.ranolp.typia.action.Action
import io.github.ranolp.typia.action.KeyPressAction
import io.github.ranolp.typia.keyboard.Keyboard
import io.github.ranolp.typia.keyboard.key.Key
import io.github.ranolp.typia.util.H2
import io.github.ranolp.typia.wordcompose.korean.KoreanWordComposer
import java.util.*


sealed class DubeolKeyboard(useFillers: Boolean, composeMode: KoreanWordComposer.ComposeMode) : Keyboard(
        Arrays.asList(
                Keys.ESC,
                Keys.TILDE,
                Keys.NUM1,
                Keys.NUM2,
                Keys.NUM3,
                Keys.NUM4,
                Keys.NUM5,
                Keys.NUM6,
                Keys.NUM7,
                Keys.NUM8,
                Keys.NUM9,
                Keys.NUM0,
                Keys.MINUS,
                Keys.EQUAL,
                Keys.BACKSPACE,
                Keys.TAB,
                Keys.Q,
                Keys.W,
                Keys.E,
                Keys.R,
                Keys.T,
                Keys.Y,
                Keys.U,
                Keys.I,
                Keys.O,
                Keys.P,
                Keys.SQUARE_BRACKET_OPEN,
                Keys.SQUARE_BRACKET_CLOSE,
                Keys.BACKSLASH,
                Keys.A,
                Keys.S,
                Keys.D,
                Keys.F,
                Keys.G,
                Keys.H,
                Keys.J,
                Keys.K,
                Keys.L,
                Keys.COLON,
                Keys.QUOTE,
                Keys.ENTER,
                Keys.SHIFT,
                Keys.Z,
                Keys.X,
                Keys.C,
                Keys.V,
                Keys.B,
                Keys.N,
                Keys.M,
                Keys.COMMA,
                Keys.DOT,
                Keys.SLASH,
                Keys.CTRL,
                Keys.ALT,
                Keys.SPACE
        ), KoreanWordComposer(useFillers, composeMode)
) {
    class Keys private constructor() {
        init {
            throw UnsupportedOperationException("You cannot instantiate DubeolStandardKeyboard.Keys")
        }

        companion object {

            val ESC = Key("ESC", 0)
            val TILDE = Key("`\n~", 1)
            val NUM1 = Key("!\n1", 2)
            val NUM2 = Key("@\n2", 3)
            val NUM3 = Key("#\n3", 4)
            val NUM4 = Key("$\n4", 5)
            val NUM5 = Key("%\n5", 6)
            val NUM6 = Key("^\n6", 7)
            val NUM7 = Key("&\n7", 8)
            val NUM8 = Key("*\n8", 9)
            val NUM9 = Key("(\n9", 10)
            val NUM0 = Key(")\n0", 11)
            val MINUS = Key("_\n-", 12)
            val EQUAL = Key("+\n=", 13)
            val BACKSPACE = Key("Backspace", 14)
            val TAB = Key("Tab", 15)
            val Q = Key("ㅂ", 16)
            val W = Key("ㅈ", 17)
            val E = Key("ㄷ", 18)
            val R = Key("ㄱ", 19)
            val T = Key("ㅅ", 20)
            val Y = Key("ㅛ", 21)
            val U = Key("ㅕ", 22)
            val I = Key("ㅑ", 23)
            val O = Key("ㅒ\nㅐ", 24)
            val P = Key("ㅖ\nㅔ", 25)
            val SQUARE_BRACKET_OPEN = Key("{\n[", 26)
            val SQUARE_BRACKET_CLOSE = Key("}\n]", 27)
            val BACKSLASH = Key("|\n\\", 28)
            val A = Key("ㅁ", 29)
            val S = Key("ㄴ", 30)
            val D = Key("ㅇ", 31)
            val F = Key("ㄹ", 32)
            val G = Key("ㅎ", 33)
            val H = Key("ㅗ", 34)
            val J = Key("ㅓ", 35)
            val K = Key("ㅏ", 36)
            val L = Key("ㅣ", 37)
            val COLON = Key(":\n;", 38)
            val QUOTE = Key("\"\n'", 39)
            val ENTER = Key("Enter", 40)
            val SHIFT = Key("Shift", 41)
            val Z = Key("ㅋ", 42)
            val X = Key("ㅌ", 43)
            val C = Key("ㅊ", 44)
            val V = Key("ㅍ", 45)
            val B = Key("ㅠ", 46)
            val N = Key("ㅜ", 47)
            val M = Key("ㅡ", 48)
            val COMMA = Key("<\n,", 49)
            val DOT = Key(">\n.", 50)
            val SLASH = Key("?\n/", 51)
            val CTRL = Key("Ctrl", 52)
            val ALT = Key("Alt", 53)
            val SPACE = Key("Space", 54)
        }
    }

    override fun handleAction(action: Action) {
        if (action is KeyPressAction) {
            when (action.key) {
                Keys.TILDE -> wordComposer.input(if (shift) '~' else '`')
                Keys.NUM1 -> wordComposer.input(if (shift) '!' else '1')
                Keys.NUM2 -> wordComposer.input(if (shift) '@' else '2')
                Keys.NUM3 -> wordComposer.input(if (shift) '#' else '3')
                Keys.NUM4 -> wordComposer.input(if (shift) '$' else '4')
                Keys.NUM5 -> wordComposer.input(if (shift) '%' else '5')
                Keys.NUM6 -> wordComposer.input(if (shift) '^' else '6')
                Keys.NUM7 -> wordComposer.input(if (shift) '&' else '7')
                Keys.NUM8 -> wordComposer.input(if (shift) '*' else '8')
                Keys.NUM9 -> wordComposer.input(if (shift) '(' else '9')
                Keys.NUM0 -> wordComposer.input(if (shift) ')' else '0')
                Keys.MINUS -> wordComposer.input(if (shift) '_' else '-')
                Keys.EQUAL -> wordComposer.input(if (shift) '+' else '=')
                Keys.BACKSPACE -> wordComposer.backspace()

                Keys.Q -> wordComposer.input(if (shift) H2.BB else H2.B)
                Keys.W -> wordComposer.input(if (shift) H2.JJ else H2.J)
                Keys.E -> wordComposer.input(if (shift) H2.DD else H2.D)
                Keys.R -> wordComposer.input(if (shift) H2.GG else H2.G)
                Keys.T -> wordComposer.input(if (shift) H2.SS else H2.S)
                Keys.Y -> wordComposer.input(H2.YO)
                Keys.U -> wordComposer.input(H2.YEO)
                Keys.I -> wordComposer.input(H2.YA)
                Keys.O -> wordComposer.input(if (shift) H2.YAE else H2.AE)
                Keys.P -> wordComposer.input(if (shift) H2.YE else H2.E)
                Keys.SQUARE_BRACKET_OPEN -> wordComposer.input(if (shift) '[' else '{')
                Keys.SQUARE_BRACKET_CLOSE -> wordComposer.input(if (shift) '}' else ']')
                Keys.BACKSLASH -> wordComposer.input(if (shift) '|' else '\\')
                Keys.A -> wordComposer.input(H2.M)
                Keys.S -> wordComposer.input(H2.N)
                Keys.D -> wordComposer.input(H2.Q)
                Keys.F -> wordComposer.input(H2.R)
                Keys.G -> wordComposer.input(H2.H)
                Keys.H -> wordComposer.input(H2.O)
                Keys.J -> wordComposer.input(H2.EO)
                Keys.K -> wordComposer.input(H2.A)
                Keys.L -> wordComposer.input(H2.I)
                Keys.COLON -> wordComposer.input(if (shift) ':' else ';')
                Keys.QUOTE -> wordComposer.input(if (shift) '"' else '\'')
                Keys.ENTER -> wordComposer.input('\n')

                Keys.Z -> wordComposer.input(H2.K)
                Keys.X -> wordComposer.input(H2.T)
                Keys.C -> wordComposer.input(H2.CH)
                Keys.V -> wordComposer.input(H2.P)
                Keys.B -> wordComposer.input(H2.YU)
                Keys.N -> wordComposer.input(H2.U)
                Keys.M -> wordComposer.input(H2.EU)
                Keys.COMMA -> wordComposer.input(if (shift) '<' else ',')
                Keys.DOT -> wordComposer.input(if (shift) '>' else '.')
                Keys.SLASH -> wordComposer.input(if (shift) '?' else '/')

                Keys.SPACE -> wordComposer.input(' ')
            }
        }
    }
}

class DubeolExtendedKeyboard(useFillers: Boolean) : DubeolKeyboard(
        useFillers,
        KoreanWordComposer.ComposeMode.DUBEOL_EXTENDED
)

class DubeolStandardKeyboard(useFillers: Boolean) : DubeolKeyboard(
        useFillers,
        KoreanWordComposer.ComposeMode.DUBEOL_STANDARD
)
