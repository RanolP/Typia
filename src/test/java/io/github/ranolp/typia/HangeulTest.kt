package io.github.ranolp.typia

import io.github.ranolp.typia.util.H2
import io.github.ranolp.typia.util.H3
import io.github.ranolp.typia.util.isCoda
import io.github.ranolp.typia.util.isNucleus
import io.github.ranolp.typia.util.isOnset
import io.github.ranolp.typia.util.toH2Coda
import io.github.ranolp.typia.util.toH2Nucleus
import io.github.ranolp.typia.util.toH2Onset
import io.github.ranolp.typia.util.toH3Coda
import io.github.ranolp.typia.util.toH3Nucleus
import io.github.ranolp.typia.util.toH3Onset
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HangeulTest {
    @Test
    fun h2ToH3() {
        assertTrue(isOnset(H2.G))
        assertEquals(toH3Onset(H2.G), H3.G_)

        assertTrue(isOnset(H2.H))
        assertEquals(toH3Onset(H2.H), H3.H_)


        assertTrue(isNucleus(H2.A))
        assertEquals(toH3Nucleus(H2.A), H3.A)

        assertTrue(isNucleus(H2.I))
        assertEquals(toH3Nucleus(H2.I), H3.I)


        assertTrue(isCoda(H2.G))
        assertEquals(toH3Coda(H2.G), H3._G)

        assertTrue(isCoda(H2.H))
        assertEquals(toH3Coda(H2.H), H3._H)
    }

    @Test
    fun h3ToH2() {
        assertTrue(isOnset(H3.G_))
        assertEquals(toH2Onset(H3.G_), H2.G)

        assertTrue(isOnset(H3.H_))
        assertEquals(toH2Onset(H3.H_), H2.H)


        assertTrue(isNucleus(H3.A))
        assertEquals(toH2Nucleus(H3.A), H2.A)

        assertTrue(isNucleus(H3.I))
        assertEquals(toH2Nucleus(H3.I), H2.I)


        assertTrue(isCoda(H3._G))
        assertEquals(toH2Coda(H3._G), H2.G)

        assertTrue(isCoda(H3._H))
        assertEquals(toH2Coda(H3._H), H2.H)
    }
}
