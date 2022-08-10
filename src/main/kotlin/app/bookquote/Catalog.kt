package app.bookquote

import com.github.demidko.aot.WordformMeaning
import java.net.URL

/**
 * Набор адресов с каталогом в порядке приоритета (если не получается скачать с первого, переходим к следующему, и так далее)
 */
class Catalog(private vararg val urls: URL) {

  private val lemmaToBook = mutableMapOf<WordformMeaning, MutableSet<Book>>()

  init {
    reloadCatalog()
  }

  fun reloadCatalog() {

  }
}