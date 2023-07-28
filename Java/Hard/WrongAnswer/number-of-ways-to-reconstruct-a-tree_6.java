class Solution {
    public int checkWays(int[][] pairs) {
        
        int n = pairs.length;
        int[] parent = new int[501];
        int[] rank = new int[501];
        for (int i = 0; i < 501; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] pair : pairs) {
            union(pair[0], pair[1], parent, rank);
        }
        int[] size = new int[501];
        for (int i = 0; i < 501; i++) {
            size[find(i, parent)]++;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < 501; i++) {
            if (size[i] > 0) {
                count++;
                max = Math.max(max, size[i]);
            }
        }
        if (count == 1) {
            return 1;
        }
        if (max == n) {
            return 2;
        }
        return 0;
    }
    
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    
    private void union(int x, int y, int[] parent, int[] rank) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) {
            return;
        }
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}