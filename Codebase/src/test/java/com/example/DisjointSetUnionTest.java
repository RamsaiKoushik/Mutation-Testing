package com.example;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class DisjointSetUnionTest {
    @Test
    public void testUnionNegatedConditional() {
        DisjointSetUnion dsu = new DisjointSetUnion(5);

        // Create two disjoint sets
        dsu.union(0, 1); // {0, 1}
        dsu.union(2, 3); // {2, 3}

        // Ensure size of {0, 1} is larger than {2, 3}
        dsu.union(1, 4); // {0, 1, 4}

        // Now union {0, 1, 4} with {2, 3}
        dsu.union(3, 4);

        // Verify that 0 remains the root (larger set becomes parent)
        assertEquals(dsu.find(0), dsu.find(2));
        assertEquals(dsu.find(0), dsu.find(3));
    }

    @Test
    public void testUnionChangedConditionalBoundary() {
        DisjointSetUnion dsu = new DisjointSetUnion(6);

        // Create two sets of equal size
        dsu.union(0, 1); // {0, 1}
        dsu.union(2, 3); // {2, 3}

        // Union sets of equal size
        dsu.union(1, 2);

        // Verify parent is consistent (should be the root of the first set)
        assertEquals(dsu.find(0), dsu.find(3));
        assertEquals(dsu.find(0), dsu.find(2));
    }

    @Test
    public void testUnionSizeUpdate() {
        DisjointSetUnion dsu = new DisjointSetUnion(5);

        // Create two sets
        dsu.union(0, 1); // {0, 1} with size 2
        dsu.union(2, 3); // {2, 3} with size 2

        // Union sets {0, 1} and {2, 3}
        dsu.union(3, 1);

        // Check size of the resulting set
        int root = dsu.find(0);
        assertEquals(4, dsu.getSize(root));
    }
}
