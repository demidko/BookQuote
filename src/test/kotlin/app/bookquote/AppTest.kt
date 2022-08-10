package app.bookquote

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory.getLogger
import java.io.ByteArrayInputStream
import java.net.URL
import java.util.zip.ZipInputStream

internal class AppTest {

  @Test
  fun lol() {
    val reader =
      URL("https://flibusta.is/catalog/catalog.zip")
        .readBytes()
    val log = getLogger("Lol")

    log.warn(reader.size.toString())

    val lines = reader.let(::ByteArrayInputStream).let(::ZipInputStream)

    log.warn(lines.readAllBytes().size.toString())
  }
}