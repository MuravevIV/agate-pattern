package com.ilyamur.agate

package object pattern {

    type HasClose = {
        def close()
    }

    /**
     * loan pattern
     * @param c closeable
     * @param f closure
     * @return
     */
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
