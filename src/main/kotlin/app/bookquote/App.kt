package app.bookquote

import org.apache.commons.csv.CSVFormat.newFormat
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.Scheduled
import java.net.URL

@SpringBootApplication
class App {

  @Value("\${catalog.url:https://flibusta.is/catalog/catalog.zip}")
  private lateinit var catalogUrl: URL

  @Bean
  fun catalog(): List<Book> {
    val reader = catalogUrl.openStream().bufferedReader()
    val parser = newFormat(';').parse(reader)
    parser.use {
      return parser.map {
        println(it)
        Book(it[0], it[1], it[2], it[3], it[4], it[5], it[6], it[7], it[8])
      }
    }
  }
}

fun main(args: Array<String>) {
  runApplication<App>(*args)
}
