package app.bookquote

import org.apache.commons.csv.CSVFormat.newFormat
import org.apache.commons.csv.CSVRecord
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory.getLogger
import java.net.URL
import java.util.zip.ZipInputStream

internal class AppTest {

  @Test
  fun lol() {

    val log = getLogger("lol")
    log.warn(javaClass.getResource("/catalog.zip").toString())
    val reader =
      URL("https://flibusta.is/catalog/catalog.zip")
        .openStream()
        .let(::ZipInputStream)
        .apply(ZipInputStream::getNextEntry)
        .bufferedReader()
        .let(newFormat(';')::parse)
    val books = reader.use {
      reader.drop(1).map(::parseBook)
    }
    log.warn("{}", books.size)
  }

  fun parseBook(r: CSVRecord): Book {
    val it = r.iterator()
    return Book(
      it.next(),
      it.next(),
      it.next(),
      it.next(),
      it.next(),
      it.next(),
      it.next(),
      it.next(),
      it.next()
    )
  }
}