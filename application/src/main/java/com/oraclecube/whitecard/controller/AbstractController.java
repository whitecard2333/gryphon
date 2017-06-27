package com.oraclecube.whitecard.controller;

/**
 * Abstract Controller as parent of other Controllers
 */
public abstract class AbstractController {
    public static final ThreadLocal<Boolean> THREAD_LOCAL = ThreadLocal.withInitial(() -> false);
}
