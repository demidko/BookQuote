package app.bookquote.models

data class Book(val author: Author, val names: Set<String>) {
  init {
    require(names.isNotEmpty())
  }
}
