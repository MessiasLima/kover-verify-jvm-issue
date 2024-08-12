package io.github.messiaslima

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform