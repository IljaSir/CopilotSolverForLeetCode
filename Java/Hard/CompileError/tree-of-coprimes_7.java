class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        int[][] dp = new int[51][n];
        for (int i = 0; i < 51; ++i) Arrays.fill(dp[i], -1);
        dfs(nums, g, dp, 0, -1);
        return ans;
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    void dfs(int[] nums, Map<Integer, List<Integer>> g, int[][] dp, int u, int p) {
        int d = -1, v = -1;
        for (int i = 1; i <= 50; ++i) {
            if (nums[u] % i == 0) {
                int j = nums[u] / i;
                if (dp[i][u] != -1 && gcd(i, j) == 1) {
                    if (d == -1 || d > dp[i][u]) {
                        d = dp[i][u];
                        v = i;
                    }
                }
            }
        }
        for (int i = 1; i <= 50; ++i) {
            if (nums[u] % i == 0) {
                dp[i][u] = d == -1 ? u : d;
            }
        }
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v != p) dfs(nums, g, dp, v, u);
        }
    }
}