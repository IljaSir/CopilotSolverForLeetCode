class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x != y) {
                parent[x] = y;
            }
        }
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            int x = find(parent, i);
            score[x] += scores[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, score[i]);
        }
        return ans;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}