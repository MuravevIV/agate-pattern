package com.ilyamur.agate

package object pattern {

    type HasClose = {
        def close()
    }

    def using[C <: HasClose, B](c: C)(f: C => B): B = {
        try {
            f(c)
        } finally {
            try {
                c.close()
            } catch {
                case e: Throwable => // ignore
            }
        }
    }
}
