class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int ans = 0;
        for (int[] e : edges) {
            if (e[0] == 3) {
                if (alice.union(e[1] - 1, e[2] - 1)) {
                    bob.union(e[1] - 1, e[2] - 1);
                } else {
                    ans++;
                }
            }
        }
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (!alice.union(e[1] - 1, e[2] - 1)) {
                    ans++;
                }
            }
            if (e[0] == 2) {
                if (!bob.union(e[1] - 1, e[2] - 1)) {
                    ans++;
                }
            }
        }
        if (alice.setCount != 1 || bob.setCount != 1) {
            return -1;
        }
        return ans;
    }
}
    }
}