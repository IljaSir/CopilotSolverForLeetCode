class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        // build the tree
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        // dp[i][j] = min #edges to collect coins in subtree i, and j = 0, 1, 2
        // j = 0 means current vertex i has no coins
        // j = 1 means current vertex i has a coin
        // j = 2 means current vertex i has a coin, and we have already collected coins from its children
        int[][] dp = new int[n][3];
        // dp[i][0] = min{dp[child][0], dp[child][1], dp[child][2]} + 1
        // dp[i][1] = min{dp[child][0], dp[child][1], dp[child][2]} + coins[i]
        // dp[i][2] = min{dp[child][0], dp[child][1], dp[child][2]} + coins[i] - 1
        dfs(tree, dp, 0, -1, coins);
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
    
    private void dfs(List<Integer>[] tree, int[][] dp, int i, int parent, int[] coins) {
        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int child : tree[i]) {
            if (child == parent) {
                continue;
            }
            dfs(tree, dp, child, i, coins);
            min0 = Math.min(min0, Math.min(dp[child][0], Math.min(dp[child][1], dp[child][2])));
            min1 = Math.min(min1, Math.min(dp[child][0], dp[child][1]));
            min2 = Math.min(min2, Math.min(dp[child][0], dp[child][1]));
        }
        dp[i][0] = min0 + 1;
        dp[i][1] = min1 + coins[i];
        dp[i][2] =
    }
}