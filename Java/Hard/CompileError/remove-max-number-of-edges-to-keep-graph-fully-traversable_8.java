class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        UnionFind alice = new UnionFind(n), bob = new UnionFind(n);
        int res = 0;
        for (int[] e : edges)
            if (e[0] == 3) {
                if (!alice.union(e[1] - 1, e[2] - 1))
                    ++res;
                else
                    bob.union(e[1] - 1, e[2] - 1);
            }
        for (int[] e : edges)
            if (e[0] == 1) {
                if (!alice.union(e[1] - 1, e[2] - 1))
                    ++res;
            } else if (e[0] == 2) {
                if (!bob.union(e[1] - 1, e[2] - 1))
                    ++res;
            }
        return alice.setCount == 1 && bob.setCount == 1 ? res : -1;
    }
}
    }
}