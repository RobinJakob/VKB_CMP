package org.e2fs4.strategy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform