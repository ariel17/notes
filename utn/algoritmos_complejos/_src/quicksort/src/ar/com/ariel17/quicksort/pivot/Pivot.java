/**
 * Pivot
 *
 * TODO Description if available.
 */

package ar.com.ariel17.quicksort.pivot;

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
     * @return TODO
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index TODO
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return TODO
     */
    public T getItem() {
        return item;
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 
