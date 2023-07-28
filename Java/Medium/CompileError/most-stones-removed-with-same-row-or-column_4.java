class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        UnionFind uf = new UnionFind(20000);
        for (int[] stone: stones)
            uf.union(stone[0], stone[1] + 10000);
        Set<Integer> seen = new HashSet();
        for (int[] stone: stones)
            seen.add(uf.find(stone[0]));
        return n - seen.size();
    }
}
    }
}