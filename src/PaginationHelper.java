import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;

public class PaginationHelper<I> {

    public static void main(String[] args) {
//        List<Integer> collection = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39);
//        PaginationHelper<Integer> helper = new PaginationHelper<>(collection, 5);

        PaginationHelper<?> helper = new PaginationHelper<>(List.of(), 10);
        System.out.println(helper.itemCount());
        System.out.println(helper.pageCount());
//        System.out.println(helper.pageIndex(0));
        System.out.println(helper.pageItemCount(0));
        System.out.println(helper.pageItemCount(1));
        System.out.println(helper.pageItemCount(2));
        System.out.println(helper.pageItemCount(4));
        System.out.println(helper.pageItemCount(7));
        System.out.println(helper.pageIndex(5));
        System.out.println(helper.pageIndex(2));
        System.out.println(helper.pageIndex(20));
        System.out.println(helper.pageIndex(-10));
    }

    private List<I> itemList;
    private int itemsPerPage;

    private int pageCount;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.itemList = collection;
        this.itemsPerPage = itemsPerPage;
        this.pageCount = itemCount() % this.itemsPerPage != 0 ? (itemCount() / this.itemsPerPage) + 1 : itemCount() / this.itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.itemList.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return this.pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int currentPage = pageIndex + 1;
        if (currentPage < 1 || currentPage > pageCount()) {
            return -1;
        } else if (pageCount() - currentPage == 0) {
            return itemCount() - (pageIndex * this.itemsPerPage);
        } else {
            return this.itemsPerPage;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || (itemIndex + 1) > itemCount()) {
            return -1;
        }
        return itemIndex / this.itemsPerPage;
    }
}