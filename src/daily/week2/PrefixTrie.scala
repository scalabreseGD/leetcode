package daily.week2

object PrefixTrie {


  class TrieRec() {

    private val placeHolder: String = "/"
    /** Initialize your data structure here. */
    var wordDictionary: Map[Char, TrieRec] = Map.empty

    private def insertInternal(word: String): Unit = {
      if (word.isEmpty) {
      } else {
        wordDictionary.get(word.head) match {
          case Some(x) => x.insertInternal(word.tail)
          case None =>
            val followingLecter = new TrieRec
            followingLecter.insertInternal(word.tail)
            wordDictionary = wordDictionary.+((word.head, followingLecter))
        }
      }
    }

    /** Inserts a word into the trie. */
    def insert(word: String) {
      insertInternal(word + placeHolder)
    }

    private def searchInternal(word: String, isPrefixed: Boolean): Boolean = {

      if (!word.isEmpty) {
        wordDictionary.get(word.head) match {
          case Some(x) => x.searchInternal(word.tail, isPrefixed)
          case None => false
        }
      } else {
        (!isPrefixed && wordDictionary.contains(placeHolder.head)) || isPrefixed
      }
    }

    /** Returns if the word is in the trie. */
    def search(word: String): Boolean = {
      searchInternal(word, isPrefixed = false)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    def startsWith(prefix: String): Boolean = {
      searchInternal(prefix, isPrefixed = true)
    }
  }

  class Trie() {
    //892

    /** Initialize your data structure here. */
    var wordDictionary: Map[Char, Set[String]] = Map.empty


    /** Inserts a word into the trie. */
    def insert(word: String) {
      if (wordDictionary.contains(word.head)) {
        wordDictionary = wordDictionary.updated(word.head, wordDictionary(word.head).+(word))
      } else {
        wordDictionary = wordDictionary.+((word.head, Set(word)))
      }
    }

    /** Returns if the word is in the trie. */
    def search(word: String): Boolean = {
      wordDictionary.get(word.head).exists(_.contains(word))
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    def startsWith(prefix: String): Boolean = {
      wordDictionary.get(prefix.head).exists(opt => opt.exists(elem => elem.startsWith(prefix)))
    }

  }

  def main(args: Array[String]): Unit = {
    //["Trie","insert","search","search","startsWith","insert","search"]
    //[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
    val trie = new TrieRec
    trie.insert("a")
    trie.insert("apple")
    assert(trie.search("apple"))
    assert(!trie.search("app"))
    assert(trie.startsWith("app"))
    trie.insert("app")
    assert(trie.search("app"))
  }

}
