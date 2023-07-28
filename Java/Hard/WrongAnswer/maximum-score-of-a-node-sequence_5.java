class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        for (int[] edge : edges) {
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if (p1 != p2) {
                if (rank[p1] < rank[p2]) {
                    parent[p1] = p2;
                } else if (rank[p2] < rank[p1]) {
                    parent[p2] = p1;
                } else {
                    parent[p1] = p2;
                    rank[p2]++;
                }
            }
        }
        int[] dp = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = scores[i];
            max[i] = scores[i];
        }
        for (int[] edge : edges) {
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if (p1 == p2) {
                continue;
            }
            dp[p2] = Math.max(dp[p2], dp[p1] + scores[p2]);
            max[p2] = Math.max(max[p2], max[p1]);
            parent[p1] = p2;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max[i]) {
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}