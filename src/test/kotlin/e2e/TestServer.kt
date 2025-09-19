package e2e

import org.junit.AfterClass
import org.junit.BeforeClass
import java.io.File
import java.util.concurrent.TimeUnit

abstract class TestServer {
    companion object {
        private lateinit var serverProcess: Process

        @BeforeClass
        @JvmStatic
        fun runServer() {
            serverProcess = runGradleApp()
            serverProcess.waitFor(10, TimeUnit.SECONDS)
        }

        @AfterClass
        @JvmStatic
        fun stopServer() {
            serverProcess.destroyForcibly()
        }

        private fun runGradleApp(): Process {
            val command = listOf("./gradlew", "run", "--no-daemon")
            val processBuilder = ProcessBuilder(command)
            processBuilder.directory(File("."))
            return processBuilder.start()
        }
    }
}