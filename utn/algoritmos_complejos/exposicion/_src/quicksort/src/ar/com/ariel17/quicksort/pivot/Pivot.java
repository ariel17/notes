/**
 * Pivot
 *
 * A pivot implementation for the Quicksort algorithm.
 */

package ar.com.ariel17.quicksort.pivot;

/**
 * The pivot implementation. Contains two elements: the item in list selected as
 * point of reference (pivot) and the position on the list to order.
 */
public class Pivot<T> {

    private int index;

    private T item;

    /**
     * Constructor
     */
    public Pivot(int index, T item) {
        this.index = index;
        this.item = item;
    }

    /**
     * @return The index for the item inside list.
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index The position of current item.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return The actual item value.
     */
    public T getItem() {
        return item;
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 
