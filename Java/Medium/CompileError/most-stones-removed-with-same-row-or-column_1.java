class Solution {
    public int removeStones(int[][] stones) {
        
        int N = stones.length;
        DSU dsu = new DSU(20000);
        for (int[] stone: stones)
            dsu.union(stone[0], stone[1] + 10000);
        Set<Integer> seen = new HashSet();
        for (int[] stone: stones)
            seen.add(dsu.find(stone[0]));
        return N - seen.size();
    }
}
    }
}