package codewars.paginationHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// TODO: complete this object/class

public class PaginationHelper<I> {

    private List<I> collection;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        double result = (double) this.collection.size() / (double) this.itemsPerPage;
        return (int) Math.ceil(result);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {

        if (pageIndex == pageCount()) return -1;

        List<List<I>> pagedList = new ArrayList<>();
        List<I> tempList = new ArrayList<>();
        for (I value : collection) {
            tempList.add(value);

            if (tempList.size() == this.itemsPerPage) {
                pagedList.add(new ArrayList<>(tempList));
                tempList.clear();
            }
        }
        int modulo = this.collection.size() % this.itemsPerPage;
        if (modulo != 0) {
            pagedList.add(collection.subList(collection.size() - modulo, collection.size()));
        }

        return pagedList.get(pageIndex).size();
    }


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex >= this.collection.size() || itemIndex < 0) {
            return -1;
        }

        return (int) Math.floor((double) itemIndex / (double) this.itemsPerPage);
    }

    public static void main(String[] args) {


        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount()); //should == 2
        System.out.println(helper.itemCount()); //should == 6
        System.out.println(helper.pageItemCount(0)); //should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5)); //should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); //should == 0
        System.out.println(helper.pageIndex(20)); //should == -1
        System.out.println(helper.pageIndex(-10)); //should == -1
    }
}