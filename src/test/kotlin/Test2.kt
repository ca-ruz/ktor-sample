import e2e.TestServer
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class EmbeddedServerTest2: TestServer() {
    @Test
    fun rootRouteRespondsWithHelloKtorString(): Unit = runBlocking {
        val response: String = HttpClient().get("http://localhost:7082/").body()
        assertEquals("Hello, Ktor", response)
    }

    @Test
    fun testRouteRespondsWithTest1(): Unit = runBlocking {
        val response: String = HttpClient().get("http://localhost:7082/test1").body()
        assertEquals("<h1>Test 1</h1>", response)
    }

    @Test
    fun samplecontentRouteRespondsWithpagebuilt(): Unit = runBlocking {
        val response: String = HttpClient().get("http://localhost:7082/content/sample.html").body()
        assertTrue(response.contains("<h1>This page is built by:</h1>"))
    }

}
