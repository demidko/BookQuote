package app.bookquote

import com.github.demidko.aot.WordformMeaning
import org.apache.commons.csv.CSVFormat
import org.springframework.util.MultiValueMap
import java.net.URL
import java.util.zip.ZipInputStream

/**
 * Набор адресов с каталогом в порядке приоритета (если не получается скачать с первого, переходим к следующему, и так далее)
 */
class Catalog(private vararg val urls: URL) {

  private val books = mutableListOf<Book>()
  private val lemmaIdToBooks = mutableMapOf<Long, MutableSet<Int>>()

  init {
    reloadCatalog()
  }

  fun reloadCatalog() {

  }
  
}