package app.bookquote

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.net.URL

internal class AppTest {

  @Test
  fun lol() {
    val reader = URL("https://flibusta.is/catalog/catalog.zip").openStream().bufferedReader()
    reader.use {
      println(reader.readLine())
    }
  }
}