package e2e

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import java.util.concurrent.TimeUnit
import java.io.File

abstract class TestServer {
    private lateinit var serverProcess: Process

    @Before
    fun runServer() {
        serverProcess = runGradleApp()
        serverProcess.waitFor(30, TimeUnit.SECONDS)
    }

    @After
    fun stopServer(): Unit = runBlocking {
        serverProcess.destroy()
    }

    private fun runGradleApp(): Process {
        val command = listOf("./gradlew", "run")
        val processBuilder = ProcessBuilder(command)
        processBuilder.directory(File("."))
        return processBuilder.start()
    }
}