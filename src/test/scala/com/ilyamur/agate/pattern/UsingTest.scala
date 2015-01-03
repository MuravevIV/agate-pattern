package com.ilyamur.agate.pattern

import org.junit.Test
import org.junit.Assert._
import org.mockito.Mockito._

class UsingTest {

    trait C {
        def close()
    }

    trait T {
        def touch()
    }

    @Test
    def using_sameRefReturned() {
        //
        val c = mock(classOf[C])
        //
        val cRef = using(c) { cc =>
            cc
        }
        //
        assertEquals(cRef, c)
    }

    @Test
    def using_closed() {
        //
        val c = mock(classOf[C])
        //
        using(c) { _ =>
            //
        }
        //
        verify(c).close()
    }

    @Test
    def using_bodyExecuted() {
        //
        val c = mock(classOf[C])
        val t = mock(classOf[T])
        //
        using(c) { _ =>
            t.touch()
        }
        //
        verify(t).touch()
    }
}
