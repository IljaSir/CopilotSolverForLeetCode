class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        UnionFind uf = new UnionFind(n + 1);
        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = 2 * i; j <= n; j += i) {
                uf.union(i, j);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(uf.find(q[0]) == uf.find(q[1]));
        }
        return ans;
    }
}
    }
}