@file:JvmName("Hangeul")

package io.github.ranolp.typia.util

import java.util.*


fun isOnset(c: Char): Boolean = c in H2.ONSET || c in H3.ONSET

fun isNucleus(c: Char): Boolean = c in H2.NUCLEUS || c in H3.NUCLEUS

fun isCoda(c: Char): Boolean = c in H2.CODA || c in H3.CODA

fun isH2Part(c: Char): Boolean = c in H2.VALUES

fun toH3Part(c: Char): Char = when {
    !isH2Part(c) -> throw IllegalArgumentException("Argument must be H2 part")
    isOnset(c) -> toH3Onset(c)
    isNucleus(c) -> toH3Nucleus(c)
    isCoda(c) -> toH3Coda(c)
    else -> throw IllegalArgumentException("Invalid H2 Character")
}

fun toH3Onset(c: Char): Char = when {
    isH2Part(c) && isOnset(c) -> H3.ONSET[Arrays.binarySearch(H2.ONSET, c)]
    else -> throw IllegalArgumentException("Argument must be H2 onset part")
}

fun toH3Nucleus(c: Char): Char = when {
    isH2Part(c) && isNucleus(c) -> H3.NUCLEUS[Arrays.binarySearch(H2.NUCLEUS, c)]
    else -> throw IllegalArgumentException("Argument must be H2 nucleus part")
}

fun toH3Coda(c: Char): Char = when {
    isH2Part(c) && isCoda(c) -> H3.CODA[Arrays.binarySearch(H2.CODA, c)]
    else -> throw IllegalArgumentException("Argument must be H2 coda part")
}

fun isH3Part(c: Char): Boolean = c in H3.VALUES

fun toH2Onset(c: Char): Char = when {
    isH3Part(c) && isOnset(c) -> H2.ONSET[Arrays.binarySearch(H3.ONSET, c)]
    else -> throw IllegalArgumentException("Argument must be H3 onset part")
}

fun toH2Nucleus(c: Char): Char = when {
    isH3Part(c) && isNucleus(c) -> H2.NUCLEUS[Arrays.binarySearch(H3.NUCLEUS, c)]
    else -> throw IllegalArgumentException("Argument must be H3 nucleus part")
}

fun toH2Coda(c: Char): Char = when {
    isH3Part(c) && isCoda(c) -> H2.CODA[Arrays.binarySearch(H3.CODA, c)]
    else -> throw IllegalArgumentException("Argument must be H2 coda part")
}

object H3 {
    /**
     * 한글 초성 채움 문자
     */
    @JvmField
    val HCF = '\u115f'

    /**
     * 한글 중성 채움 문자
     */
    @JvmField
    val HJF = '\u1160'

    /**
     * 초성 ㄱ
     */
    @JvmField
    val G_ = 'ᄀ'
    /**
     * 초성 ㄲ
     */
    @JvmField
    val GG_ = 'ᄁ'
    /**
     * 초성 ㄴ
     */
    @JvmField
    val N_ = 'ᄂ'
    /**
     * 초성 ㄷ
     */
    @JvmField
    val D_ = 'ᄃ'
    /**
     * 초성 ㄸ
     */
    @JvmField
    val DD_ = 'ᄄ'
    /**
     * 초성 ㄹ
     */
    @JvmField
    val R_ = 'ᄅ'
    /**
     * 초성 ㅁ
     */
    @JvmField
    val M_ = 'ᄆ'
    /**
     * 초성 ㅂ
     */
    @JvmField
    val B_ = 'ᄇ'
    /**
     * 초성 ㅃ
     */
    @JvmField
    val BB_ = 'ᄈ'
    /**
     * 초성 ㅅ
     */
    @JvmField
    val S_ = 'ᄉ'
    /**
     * 초성 ㅆ
     */
    @JvmField
    val TT_ = 'ᄊ'
    /**
     * 초성 ㅇ
     */
    @JvmField
    val Q_ = 'ᄋ'
    /**
     * 초성 ㅈ
     */
    @JvmField
    val J_ = 'ᄌ'
    /**
     * 초성 ㅉ
     */
    @JvmField
    val JJ_ = 'ᄍ'
    /**
     * 초성 ㅊ
     */
    @JvmField
    val CH_ = 'ᄎ'
    /**
     * 초성 ㅋ
     */
    @JvmField
    val K_ = 'ᄏ'
    /**
     * 초성 ㅌ
     */
    @JvmField
    val T_ = 'ᄐ'
    /**
     * 초성 ㅍ
     */
    @JvmField
    val P_ = 'ᄑ'
    /**
     * 초성 ㅎ
     */
    @JvmField
    val H_ = 'ᄒ'


    /*
     * 중성 ㅏ
     */
    @JvmField
    val A = 'ᅡ'
    /*
     * 중성 ㅐ
     */
    @JvmField
    val AE = 'ᅢ'
    /*
     * 중성 ㅑ
     */
    @JvmField
    val YA = 'ᅣ'
    /*
     * 중성 ㅒ
     */
    @JvmField
    val YAE = 'ᅤ'
    /*
     * 중성 ㅓ
     */
    @JvmField
    val EO = 'ᅥ'
    /*
     * 중성 ㅔ
     */
    @JvmField
    val E = 'ᅦ'
    /*
     * 중성 ㅕ
     */
    @JvmField
    val YEO = 'ᅧ'
    /*
     * 중성 ㅖ
     */
    @JvmField
    val YE = 'ᅨ'
    /*
     * 중성 ㅗ
     */
    @JvmField
    val O = 'ᅩ'
    /*
     * 중성 ㅘ
     */
    @JvmField
    val WA = 'ᅪ'
    /*
     * 중성 ㅙ
     */
    @JvmField
    val WAE = 'ᅫ'
    /*
     * 중성 ㅚ
     */
    @JvmField
    val OE = 'ᅬ'
    /*
     * 중성 ㅛ
     */
    @JvmField
    val YO = 'ᅭ'
    /*
     * 중성 ㅜ
     */
    @JvmField
    val U = 'ᅮ'
    /*
     * 중성 ㅝ
     */
    @JvmField
    val WO = 'ᅯ'
    /*
     * 중성 ㅞ
     */
    @JvmField
    val WE = 'ᅰ'
    /*
     * 중성 ㅟ
     */
    @JvmField
    val WI = 'ᅱ'
    /*
     * 중성 ㅠ
     */
    @JvmField
    val YU = 'ᅲ'
    /*
     * 중성 ㅡ
     */
    @JvmField
    val EU = 'ᅳ'
    /*
     * 중성 ㅢ
     */
    @JvmField
    val UI = 'ᅴ'
    /*
     * 중성 ㅣ
     */
    @JvmField
    val I = 'ᅵ'

    /*
     * 종성 ㄱ
     */
    @JvmField
    val _G = 'ᆨ'
    /*
     * 종성 ㄲ
     */
    @JvmField
    val _GG = 'ᆩ'
    /*
     * 종성 ㄳ
     */
    @JvmField
    val _GS = 'ᆪ'
    /*
     * 종성 ㄴ
     */
    @JvmField
    val _N = 'ᆫ'
    /*
     * 종성 ㄵ
     */
    @JvmField
    val _NJ = 'ᆬ'
    /*
     * 종성 ㄶ
     */
    @JvmField
    val _NH = 'ᆭ'
    /*
     * 종성 ㄷ
     */
    @JvmField
    val _D = 'ᆮ'
    /*
     * 종성 ㄹ
     */
    @JvmField
    val _R = 'ᆯ'
    /*
     * 종성 ㄺ
     */
    @JvmField
    val _RG = 'ᆰ'
    /*
     * 종성 ㄻ
     */
    @JvmField
    val _RM = 'ᆱ'
    /*
     * 종성 ㄼ
     */
    @JvmField
    val _RB = 'ᆲ'
    /*
     * 종성 ㄽ
     */
    @JvmField
    val _RS = 'ᆳ'
    /*
     * 종성 ㄾ
     */
    @JvmField
    val _RT = 'ᆴ'
    /*
     * 종성 ㄿ
     */
    @JvmField
    val _RP = 'ᆵ'
    /*
     * 종성 ㅀ
     */
    @JvmField
    val _RH = 'ᆶ'
    /*
     * 종성 ㅁ
     */
    @JvmField
    val _M = 'ᆷ'
    /*
     * 종성 ㅂ
     */
    @JvmField
    val _B = 'ᆸ'
    /*
     * 종성 ㅄ
     */
    @JvmField
    val _BS = 'ᆹ'
    /*
     * 종성 ㅅ
     */
    @JvmField
    val _S = 'ᆺ'
    /*
     * 종성 ㅆ
     */
    @JvmField
    val _SS = 'ᆻ'
    /*
     * 종성 ㅇ
     */
    @JvmField
    val _Q = 'ᆼ'
    /*
     * 종성 ㅈ
     */
    @JvmField
    val _J = 'ᆽ'
    /*
     * 종성 ㅊ
     */
    @JvmField
    val _CH = 'ᆾ'
    /*
     * 종성 ㅋ
     */
    @JvmField
    val _K = 'ᆿ'
    /*
     * 종성 ㅌ
     */
    @JvmField
    val _T = 'ᇀ'
    /*
     * 종성 ㅍ
     */
    @JvmField
    val _P = 'ᇁ'
    /*
     * 종성 ㅎ
     */
    @JvmField
    val _H = 'ᇂ'

    @JvmField
    val ONSET = charArrayOf(G_, GG_, N_, D_, DD_, R_, M_, B_, BB_, S_, TT_, Q_, J_, JJ_, CH_, K_, T_, P_, H_)
    @JvmField
    val NUCLEUS = charArrayOf(A, AE, YA, YAE, EO, E, YEO, YE, O, WA, WAE, OE, YO, U, WO, WE, WI, YU, EU, UI, I)
    @JvmField
    val CODA = charArrayOf(
            _G,
            _GG,
            _N,
            _NJ,
            _NH,
            _D,
            _R,
            _RG,
            _RM,
            _RB,
            _RS,
            _RT,
            _RP,
            _RH,
            _M,
            _B,
            _S,
            _SS,
            _Q,
            _J,
            _CH,
            _K,
            _T,
            _P,
            _H
    )

    @JvmField
    val VALUES = charArrayOf(
            G_,
            GG_,
            N_,
            D_,
            DD_,
            R_,
            M_,
            B_,
            BB_,
            S_,
            TT_,
            Q_,
            J_,
            JJ_,
            CH_,
            K_,
            T_,
            P_,
            H_,
            A,
            AE,
            YA,
            YAE,
            EO,
            E,
            YEO,
            YE,
            O,
            WA,
            WAE,
            OE,
            YO,
            U,
            WO,
            WE,
            WI,
            YU,
            EU,
            UI,
            I,
            _G,
            _GG,
            _N,
            _NJ,
            _NH,
            _D,
            _R,
            _RG,
            _RM,
            _RB,
            _RS,
            _RT,
            _RP,
            _RH,
            _M,
            _B,
            _S,
            _SS,
            _Q,
            _J,
            _CH,
            _K,
            _T,
            _P,
            _H
    )
}

object H2 {

    /**
     * 자음 ㄱ
     */
    @JvmField
    val G = 'ㄱ'
    /**
     * 자음 ㄲ
     */
    @JvmField
    val GG = 'ㄲ'
    /**
     * 자음 ㄳ
     */
    @JvmField
    val GS = 'ㄳ'
    /**
     * 자음 ㄴ
     */
    @JvmField
    val N = 'ㄴ'
    /**
     * 자음 ㄵ
     */
    @JvmField
    val NJ = 'ㄵ'
    /**
     * 자음 ㄶ
     */
    @JvmField
    val NH = 'ㄶ'
    /**
     * 자음 ㄷ
     */
    @JvmField
    val D = 'ㄷ'
    /**
     * 자음 ㄸ
     */
    @JvmField
    val DD = 'ㄸ'
    /**
     * 자음 ㄹ
     */
    @JvmField
    val R = 'ㄹ'
    /**
     * 자음 ㄺ
     */
    @JvmField
    val RG = 'ㄺ'
    /**
     * 자음 ㄻ
     */
    @JvmField
    val RM = 'ㄻ'
    /**
     * 자음 ㄼ
     */
    @JvmField
    val RB = 'ㄼ'
    /**
     * 자음 ㄽ
     */
    @JvmField
    val RS = 'ㄽ'
    /**
     * 자음 ㄾ
     */
    @JvmField
    val RT = 'ㄾ'
    /**
     * 자음 ㄿ
     */
    @JvmField
    val RP = 'ㄿ'
    /**
     * 자음 ㅀ
     */
    @JvmField
    val RH = 'ㅀ'
    /**
     * 자음 ㅁ
     */
    @JvmField
    val M = 'ㅁ'
    /**
     * 자음 ㅂ
     */
    @JvmField
    val B = 'ㅂ'
    /**
     * 자음 ㅃ
     */
    @JvmField
    val BB = 'ㅃ'
    /**
     * 자음 ㅄ
     */
    @JvmField
    val BS = 'ㅄ'
    /**
     * 자음 ㅅ
     */
    @JvmField
    val S = 'ㅅ'
    /**
     * 자음 ㅆ
     */
    @JvmField
    val SS = 'ㅆ'
    /**
     * 자음 ㅇ
     */
    @JvmField
    val Q = 'ㅇ'
    /**
     * 자음 ㅈ
     */
    @JvmField
    val J = 'ㅈ'
    /**
     * 자음 ㅉ
     */
    @JvmField
    val JJ = 'ㅉ'
    /**
     * 자음 ㅊ
     */
    @JvmField
    val CH = 'ㅊ'
    /**
     * 자음 ㅋ
     */
    @JvmField
    val K = 'ㅋ'
    /**
     * 자음 ㅌ
     */
    @JvmField
    val T = 'ㅌ'
    /**
     * 자음 ㅍ
     */
    @JvmField
    val P = 'ㅍ'
    /**
     * 자음 ㅎ
     */
    @JvmField
    val H = 'ㅎ'

    /**
     * 모음 ㅏ
     */
    @JvmField
    val A = 'ㅏ'
    /**
     * 모음 ㅐ
     */
    @JvmField
    val AE = 'ㅐ'
    /**
     * 모음 ㅑ
     */
    @JvmField
    val YA = 'ㅑ'
    /**
     * 모음 ㅒ
     */
    @JvmField
    val YAE = 'ㅒ'
    /**
     * 모음 ㅓ
     */
    @JvmField
    val EO = 'ㅓ'
    /**
     * 모음 ㅔ
     */
    @JvmField
    val E = 'ㅔ'
    /**
     * 모음 ㅕ
     */
    @JvmField
    val YEO = 'ㅕ'
    /**
     * 모음 ㅒ
     */
    @JvmField
    val YE = 'ㅒ'
    /**
     * 모음 ㅗ
     */
    @JvmField
    val O = 'ㅗ'
    /**
     * 모음 ㅘ
     */
    @JvmField
    val WA = 'ㅘ'
    /**
     * 모음 ㅙ
     */
    @JvmField
    val WAE = 'ㅙ'
    /**
     * 모음 ㅚ
     */
    @JvmField
    val OE = 'ㅚ'
    /**
     * 모음 ㅛ
     */
    @JvmField
    val YO = 'ㅛ'
    /**
     * 모음 ㅜ
     */
    @JvmField
    val U = 'ㅜ'
    /**
     * 모음 ㅝ
     */
    @JvmField
    val WO = 'ㅝ'
    /**
     * 모음 ㅞ
     */
    @JvmField
    val WE = 'ㅞ'
    /**
     * 모음 ㅟ
     */
    @JvmField
    val WI = 'ㅟ'
    /**
     * 모음 ㅠ
     */
    @JvmField
    val YU = 'ㅠ'
    /**
     * 모음 ㅡ
     */
    @JvmField
    val EU = 'ㅡ'
    /**
     * 모음 ㅢ
     */
    @JvmField
    val UI = 'ㅢ'
    /**
     * 모음 ㅣ
     */
    @JvmField
    val I = 'ㅣ'

    @JvmField
    val ONSET = charArrayOf(G, GG, N, D, DD, R, M, B, BB, S, SS, Q, J, JJ, CH, K, T, P, H)

    @JvmField
    val NUCLEUS = charArrayOf(A, AE, YA, YAE, EO, E, YEO, YE, O, WA, WAE, OE, YO, U, WO, WE, WI, YU, EU, UI, I)

    @JvmField
    val CODA = charArrayOf(G, GG, N, NJ, NH, D, R, RG, RM, RB, RS, RT, RP, RH, M, B, S, SS, Q, J, CH, K, T, P, H)

    @JvmField
    val VALUES = charArrayOf(
            G,
            GG,
            N,
            NJ,
            NH,
            D,
            DD,
            R,
            RG,
            RM,
            RB,
            RS,
            RT,
            RP,
            RH,
            M,
            B,
            BB,
            S,
            SS,
            Q,
            J,
            JJ,
            CH,
            K,
            T,
            P,
            H,
            A,
            AE,
            YA,
            YAE,
            EO,
            E,
            YEO,
            YE,
            O,
            WA,
            WAE,
            OE,
            YO,
            U,
            WO,
            WE,
            WI,
            YU,
            EU,
            UI,
            I
    )
}
