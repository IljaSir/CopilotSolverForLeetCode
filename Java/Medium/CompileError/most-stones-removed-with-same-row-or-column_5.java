class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = stones[i][0], y = stones[i][1];
            if (!rows.containsKey(x)) rows.put(x, new ArrayList<>());
            if (!cols.containsKey(y)) cols.put(y, new ArrayList<>());
            rows.get(x).add(i);
            cols.get(y).add(i);
        }
        for (List<Integer> row: rows.values())
            for (int i = 1; i < row.size(); i++)
                uf.union(row.get(i), row.get(i-1));
        for (List<Integer> col: cols.values())
            for (int i = 1; i < col.size(); i++)
                uf.union(col.get(i), col.get(i-1));
        return n - uf.count;
    }
}
    }
}