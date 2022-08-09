package app.bookquote

import org.apache.commons.csv.CSVFormat.newFormat
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.net.URL
import java.util.zip.GZIPInputStream

@SpringBootApplication
class App {

  @Value("\${catalog.url:https://flibusta.is/catalog/catalog.zip}")
  private lateinit var catalogUrl: URL

  @Bean
  fun catalog(): List<Book> {
    val reader = catalogUrl.openStream().let(::GZIPInputStream).bufferedReader()
    val parser = newFormat(';').parse(reader)
    parser.use {
      return parser.map {
        Book(it[0], it[1], it[2], it[3], it[4], it[5], it[6], it[7], it[8])
      }
    }
  }
}

fun main(args: Array<String>) {
  runApplication<App>(*args)
}
