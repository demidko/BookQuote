package app.bookquote

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory.getLogger
import java.net.URL
import java.util.zip.GZIPInputStream
import java.util.zip.ZipInputStream

internal class AppTest {

  @Test
  fun lol() {
    val reader = URL("https://flibusta.is/catalog/catalog.zip").openStream().let(::ZipInputStream).bufferedReader()
    val log = getLogger("Lol")
    log.warn(reader.readLine())
  }
}