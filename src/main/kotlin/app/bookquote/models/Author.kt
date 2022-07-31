package app.bookquote.models

data class Author(private val names: Set<Set<String>>) {

  constructor(name: HumanName) : this(setOf(name))
}
