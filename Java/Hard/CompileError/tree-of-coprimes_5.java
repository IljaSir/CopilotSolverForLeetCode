class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] ans = new int[n];
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        int[][] dp = new int[51][n];
        for (int i = 0; i < 51; i++) {
            Arrays.fill(dp[i], -1);
        }
        dfs(tree, nums, 0, 0, dp);
        return ans;
    }
    
    private void dfs(List<Integer>[] tree, int[] nums, int u, int p, int[][] dp) {
        int maxLevel = 0;
        int ancestor = -1;
        for (int v = 1; v <= 50; v++) {
            if (gcd(v, nums[u]) == 1) {
                if (dp[v][p] > maxLevel) {
                    maxLevel = dp[v][p];
                    ancestor = dp[v][p];
                }
            }
        }
        dp[nums[u]][u] = Math.max(dp[nums[u]][u], maxLevel + 1);
        for (int v : tree[u]) {
            if (v != p) {
                dfs(tree, nums, v, u, dp);
            }
        }
    }
}