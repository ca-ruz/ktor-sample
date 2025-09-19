package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        staticResources("/content", "mycontent")

        get("/") {
            call.respondText("Hello, Ktor")
        }

        get("/test1") {
            val text = "<h1>Test 1</h1>"
            val type = ContentType.parse("text/html")
            call.respondText(text, type)
        }

    }
}
