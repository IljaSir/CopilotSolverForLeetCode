class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge: edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x != y) {
                if (size[x] > size[y]) {
                    size[x] += size[y];
                    parent[y] = x;
                } else {
                    size[y] += size[x];
                    parent[x] = y;
                }
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (find(parent, i) == i) {
                max = Math.max(max, dfs(dp, parent, size, scores, i));
            }
        }
        return max;
    }
    public int dfs(int[] dp, int[] parent, int[] size, int[] scores, int i) {
        if (dp[i] != -1) return dp[i];
        int max = 0;
        for (int j = 0; j < parent.length; j++) {
            if (parent[j] == i) {
                max = Math.max(max, dfs(dp, parent, size, scores, j));
            }
        }
        return dp[i] = max + scores[i];
    }
}