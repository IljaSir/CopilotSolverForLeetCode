class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            score[i] = scores[i];
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, size, score);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, score[i]);
        }
        return max;
    }
    
    private int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
    
    private void union(int x, int y, int[] parent, int[] size, int[] score) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px != py) {
            if (size[px] > size[py]) {
                parent[py] = px;
                size[px] += size[py];
                score[px] += score[py];
            } else {
                parent[px] = py;
                size[py] += size[px];
                score[py] += score[px];
            }
        }
    }
}