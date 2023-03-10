import kotlin.math.ceil

/**
 * Description at
 * https://www.codewars.com/kata/515bb423de843ea99400000a/train/kotlin
 *
 */

fun main() {
    val helper = PaginationHelper<Int>(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 3)
    println("itemCount ${helper.itemCount}") //11
    println("pageItemCount ${helper.pageItemCount(4)}") // 2
    println("pageIndex ${helper.pageIndex(9)}") //
    println("pageIndex ${helper.pageIndex(10)}")
    println("pageIndex ${helper.pageIndex(11)}") //
    println("pageCount ${helper.pageCount}")
    println("itemCount ${helper.itemCount}")
}

class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {

    /**
     * returns the number of items within the entire collection
     */
    val itemCount: Int = collection.size

    /**
     * returns the number of pages
     */
    val pageCount: Int = ceil((collection.size).toDouble() / itemsPerPage).toInt()


    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    fun pageItemCount(pageIndex: Int): Int {
        if (pageIndex >= ceil((collection.size).toDouble() / itemsPerPage).toInt() || pageIndex < 0) {
            return -1
        } else {
            collection.chunked(itemsPerPage).also {
                return it[pageIndex].size
            }
        }
    }


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    fun pageIndex(itemIndex: Int): Int {
        return if (itemIndex >= collection.size || itemIndex < 0) {
            -1
        } else {
            itemIndex / itemsPerPage
        }
    }
}
