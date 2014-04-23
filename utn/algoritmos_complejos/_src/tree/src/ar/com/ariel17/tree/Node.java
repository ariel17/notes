/**
 * Node
 *
 * A generic logical node implementation.
 */

package ar.com.ariel17.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * A logical node implementation. Contains information stored of type T and
 * references to other nodes: its parent (up) and children (bellow).
 *
 * @author ariel17 (ariel.gerardo.rios@gmail.com)
 */
class Node<T> {

    private T info;

    private List<Node<T>> children;

    private Node<T> parent;

    /**
     * Constructor.
     *
     * @param info The inmutable information contained in node.
     */
    public Node(T info) {
        this(info, null, null);
    }

    /**
     * Constructor.
     *
     * @param info The inmutable information contained in node.
     * @param parent The parent node.
     */
    public Node(T info, Node<T> parent) {
        this(info, parent, null);
    }

    /**
     * Constructor.
     *
     * @param info The inmutable information contained in node.
     * @param parent The parent node.
     * @param children A list of nodes as children.
     */
    public Node(T info, Node<T> parent, List<Node<T>> children) {
        this.info = info;
        this.parent = parent;
        this.children = new ArrayList<Node<T>>();
    }

    /**
     * Returns the instance contained in info.
     *
     * @return The info instance.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Returns the list of children nodes.
     *
     * @return The list of children.
     */
    public List<Node<T>> getChildren() {
        return children;
    }

    /**
     * Returns a list containing only the info instance of nodes.
     *
     * @return A list of node information.
     */
    public List<T> getChildrenInfo() {
        List<T> list = new ArrayList<T>();
        for(Node<T> node: children) {
            list.add(node.getInfo());
        }
        return list;
    }

    /**
     * Returns the parent node.
     * 
     * @return The parent node.
     */
    public Node<T> getParent() {
        return parent;
    }

    /**
     * Sets the parent node instance.
     *
     * @param parent The parent node to set.
     */
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    /**
     * Adds a child node.
     *
     * @param child The instance to add as child.
     */
    public void addChild(Node<T> child) {
        children.add(child);
    }

    /**
     * Adds a list of nodes into as children.
     *
     * @param children The node list to add as children.
     */
    public void addChildren(List<Node<T>> child) {
        children.addAll(children);
    }

    /**
     * Removes the indicated child from children list.
     *
     * @param child The child node to remove.
     */
    public void removeChild(Node<T> child) {
        children.remove(child);
    }

    /**
     * Removes the indicated children list from the stored children list.
     *
     * @param children The children nodes to remove.
     */
    public void removeChildren(List<Node<T>> children) {
        children.removeAll(children);
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 
