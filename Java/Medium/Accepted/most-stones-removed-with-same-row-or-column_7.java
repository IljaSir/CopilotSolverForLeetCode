class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) uf[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(uf, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (uf[i] == i) res++;
        }
        return n - res;
    }
    
    private int find(int[] uf, int i) {
        if (uf[i] != i) {
            uf[i] = find(uf, uf[i]);
        }
        return uf[i];
    }
    
    private void union(int[] uf, int i, int j) {
        int p = find(uf, i), q = find(uf, j);
        if (p != q) {
            uf[p] = q;
        }
    }
}