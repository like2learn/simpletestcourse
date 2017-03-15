package com.e16.task_018;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Obtaining the size of the maximum
 * set(Union) qualify by {@link #UNION_QUALIFIER}
 * from a given two-dimensional array {@link #values}
 */
public class Pool {
    private static final Logger log =
            LoggerFactory.getLogger(Pool.class);
    private static final String ARRAY_IS_NULL = "Array is null";
    private static final Integer UNION_QUALIFIER = 1;

    private final int[][] values;

    public Pool(final int[][] values) {
        this.values = values;
        log.info("Call Pool constructor");
    }

    /**
     * Return the size of max Union from {@link #values}
     * @return size of max Union
     * @throws IllegalStateException if array is null
     */
    public int maxUnion() throws IllegalStateException {
        if (values == null) {
            log.error(ARRAY_IS_NULL);
            throw new IllegalStateException(ARRAY_IS_NULL);
        }

        return maxUnionHelper();
    }

    /**
     * Helper to get the size of max Union
     * qualify by {@link #UNION_QUALIFIER}
     * @return size of max Union
     */
    private int maxUnionHelper() {
        log.info("Fill deque of Nodes from array Values");
        final Deque<Node> nodes = fillNodesFromValues();
        final ArrayList<ArrayList<Node>> allUnions = new ArrayList<>();

        log.info("Fill Unions from Nodes");
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            ArrayList<Node> union = new ArrayList<>();
            fillUnion(node, nodes, union);
            allUnions.add(union);
        }

        log.info("Get valid Unions from all Unions");
        final ArrayList<ArrayList<Node>> validUnions =
                getValidUnions(allUnions, UNION_QUALIFIER);

        log.info("Get max size of valid Unions");
        int maxUnionSize = 0;
        for (ArrayList<Node> u : validUnions) {
            if (u.size() > maxUnionSize) {
                maxUnionSize = u.size();
            }
        }
        log.info("Return the size of max Union");
        return maxUnionSize;
    }

    /**
     * Select valid unions from all Unions,
     * validation by {@link #isUnionValid(ArrayList, Integer)}
     * @param allUnions all available unions
     * @param unionQualifier qualifier for checking Union
     * @return arrayList of valid unions
     */
    private ArrayList<ArrayList<Node>> getValidUnions(
            final ArrayList<ArrayList<Node>> allUnions, Integer unionQualifier) {
        final ArrayList<ArrayList<Node>> validUnions = new ArrayList<>();

        for(ArrayList<Node> union: allUnions) {
            if (isUnionValid(union, unionQualifier)) {
                validUnions.add(union);
            }
        }

        return validUnions;
    }

    /**
     * Check union if contains the Nodes with value equals qualifier
     * @param union union of Nodes for checking
     * @param unionQualifier qualifier for checking
     * @return true if contains, otherwise else
     */
    private boolean isUnionValid(ArrayList<Node> union, Integer unionQualifier) {
        Node node = union.get(0);

        return unionQualifier.equals(node.getValue());
    }

    /**
     * Fill the Nodes from array {@link #values}
     * @return filled ArrayDeque's of Nodes
     */
    private Deque<Node> fillNodesFromValues() {
        Deque<Node> nodes = new ArrayDeque<>();

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                nodes.push(new Node(i, j, values[i][j]));
            }
        }

        return nodes;
    }

    /**
     * Recursively fill the Union, using {@link #getBlankNodes(int, int, int)}
     * and {@link #hasNeighbors(List, Node, Deque, ArrayList)}
     * @param node Node to check
     * @param nodes deque of remaining Nodes for check
     * @param union arrayList for suitable Nodes
     */
    private void fillUnion(final Node node, final Deque<Node> nodes,
                           final ArrayList<Node> union) {
        union.add(node);
        final int x = node.getX();
        final int y = node.getY();
        final int value = node.getValue();

        List<Node> blankNodes = getBlankNodes(x, y, value);

        for (int i = 0; i < nodes.size(); i++) {
            Node currentNode = nodes.pop();
            if (hasNeighbors(blankNodes, currentNode, nodes, union)) {
                /* The order of nodes is changing, we have to check each one */
                i = 0;
            } else {
                nodes.offer(currentNode);
            }
        }
    }

    /**
     * Check neighbors of Node, and recursively fill the Union
     * @param blanksNodes blanks of Nodes neighbors
     * @param currentNode target Node
     * @param nodes deque of remaining Nodes for check
     * @param union arrayList of suitable Nodes
     * @return true if one of the blanks came up, otherwise false
     */
    private boolean hasNeighbors(final List<Node> blanksNodes,
                                 final Node currentNode, final Deque<Node> nodes,
                                 final ArrayList<Node> union) {
        for (Node blank : blanksNodes) {
            if (currentNode.equals(blank)) {
                fillUnion(currentNode, nodes, union);
                return true;
            }
        }
        return false;
    }

    /**
     * Get the blanks of Node neighbors
     * @param x line of node
     * @param y column of node
     * @param value value of node
     * @return arrayList of blanks
     */
    private List<Node> getBlankNodes(final int x, final int y, final int value) {
        List<Node> blankNodes = new ArrayList<>();

        Node topBlankNode = new Node(x - 1,  y, value);
        Node bottomBlankNode = new Node(x + 1,  y, value);
        Node leftBlankNode = new Node(x,  y - 1, value);
        Node rightBlankNode = new Node(x,  y + 1, value);

        blankNodes.add(topBlankNode);
        blankNodes.add(bottomBlankNode);
        blankNodes.add(leftBlankNode);
        blankNodes.add(rightBlankNode);

        return blankNodes;
    }


    /**
     * Unit of Union
     * x - number of line
     * y - number of column
     * value - value on the cross of line and column
     */
    public class Node {
        private final int x;
        private final int y;
        private final int value;

        public Node(final int x, final int y, final int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            if (y != node.y) return false;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + value;
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    '}';
        }
    }
}
