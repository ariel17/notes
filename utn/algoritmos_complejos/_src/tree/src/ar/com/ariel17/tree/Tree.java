/**
 * Tree
 *
 * A string node implementation to merge strings on common characters.
 */

package ar.com.ariel17.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * A tree implementation to merge common characters on many strings. It can
 * recompose all matching words against an indicated prefix.
 *
 * @author ariel17 (ariel.gerardo.rios@gmail.com)
 */
class Tree {

    private Node<Character> root = new Node<Character>('/');

    /**
     * Constructor.
     */
    public Tree() {
    }

    /**
     * Constructor.
     *
     * @param value The initial string to process.
     */
    public Tree(String value) {
        processString(value);
    }

    /**
     * The main method to execute the program.
     *
     * @param args Program arguments.
     */
    public static void main (String [] args) {
        Tree tree = new Tree();
        tree.processString("pablo");
        tree.processString("paula");
        tree.processString("pedro");
        tree.processString("ariel");
        tree.processString("adrian");

        for (String word: tree.getResults("a")) {
            System.out.println(word);
        }
    }

    /**
     * Decomposes an string and merges it into the existent tree structure. It
     * follows the existent path to deposite new character nodes bellow the
     * existent ones.
     *
     * @param value The string to decompose.
     */
    public void processString(String value) {

        System.out.println("Processing string: " + value);

        if (value.isEmpty()) {
            return;
        }

        List<Node<Character>> newNodes = stringToList(value);
        Node<Character> newRoot = newNodes.get(0);

        if (root.getChildren().size() == 0) {
            newRoot.setParent(root);
            root.addChild(newRoot);
            return;
        }

        mergeTrees(root, newRoot);
    }

    /**
     * Generates all words matching the prefix, following the tree path.
     *
     * @param prefix The prefix string as tree path selector.
     * @return A list of words matching the indicated prefix.
     */
    public List<String> getResults(String prefix) {
        List<String> list = new ArrayList<String>();

        if (prefix.isEmpty()) {
            return list;
        }

        List<Node<Character>> prefixNodes = stringToList(prefix);
        Node<Character> lastNode = getLastMatchingNode(root, prefixNodes.get(0));
        System.out.println(lastNode.getInfo());
        System.out.println(lastNode.getParent().getInfo());

        List<String> words = new ArrayList<String>();
        for(Node<Character> child: lastNode.getChildren()) {
            words.addAll(generateWords(prefix, child));
        }

        return words;
    }

    /**
     * Generates all possible words itering over the node structure in the
     * indicated instance.
     *
     * @param prefix The string prefix to apply to all generated words.
     * @param node The initial node to follow children and generate words.
     * @return A list of generated words.
     */
    private List<String> generateWords(String prefix, Node<Character> node) {
        List<String> list = new ArrayList<String>();
        String word = prefix + node.getInfo().charValue();

        if (node.getChildren().size() == 0) {
            list.add(word);
            return list;
        }

        for(Node<Character> child: node.getChildren()) {
            list.addAll(generateWords(word, child));
        }

        return list;
    }

    /**
     * Given a decomposed string into a list of nodes, finds the last common
     * node in the stored tree node structure (the last letter in common).
     *
     * @param root The root node for the stored tree structure.
     * @param prefixRoot The root node from the prefix string list decomposed.
     * @return A node containing the last common letter in common.
     */
    private Node<Character> getLastMatchingNode(
            Node<Character> root, Node<Character> prefixRoot) {

        if (root.getChildrenInfo().contains(prefixRoot.getInfo())) {
            for (Node<Character> child: root.getChildren()) {
                if (child.getInfo() == prefixRoot.getInfo()) {
                    if (prefixRoot.getChildren().size() == 0) {
                        return child;
                    }
                    return getLastMatchingNode(child, prefixRoot.getChildren().get(0));
                }
            }
        }

        // All nodes are contained on the current tree
        if (prefixRoot.getChildren().size() == 0) {
            return root;
        }

        // prefixRoot only has 1 child node
        Node<Character> pChild = prefixRoot.getChildren().get(0);

        // itering over the root children to reset roots calling 
        // mergeTrees recursively
        for (Node<Character> child: root.getChildren()) {
            if (child.getInfo() == pChild.getInfo()) {
                return getLastMatchingNode(child, pChild);
            }
        }

        return root;
    }

    /**
     * Given a new node list, deposites it (all or part of it) bellow the last
     * common node.
     *
     * @param root The root node for the stored tree structure.
     * @param newRoot The root node from the new list to merge into the tree
     * structure.
     */
    private void mergeTrees(Node<Character> root, Node<Character> newRoot) {

        if (!root.getChildrenInfo().contains(newRoot.getInfo())) {
            newRoot.setParent(root);
            root.addChild(newRoot);
            return;
        }

        if (newRoot.getChildren().size() == 0) {
            return;  // nothing to do; all new tree contained.
        }

        for (Node<Character> child: root.getChildren()) {
            if (child.getInfo() == newRoot.getInfo()) {
                mergeTrees(child, newRoot.getChildren().get(0));
            }
        }
    }

    /**
     * Converts a string into a list of linked nodes.
     *
     * @param value The string to decompose.
     * @return A linked list of nodes.
     */
    private List<Node<Character>> stringToList(String value) {
        Node<Character> previous = null;
        Node<Character> actual = null;
        List<Node<Character>> list = new ArrayList<Node<Character>>();

        for (char c: value.toLowerCase().toCharArray()) {
            actual = new Node<Character>(c, previous);
            if (previous != null) {
                actual.setParent(previous);
                previous.addChild(actual);
            }

            list.add(actual);
            previous = actual;
        }

        return list;
    }

}

// vim:ft=java ts=4 tw=80 cc=+1: 
