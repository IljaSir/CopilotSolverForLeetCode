class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        int[] ans = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(parents[i], new ArrayList<>());
            map.get(parents[i]).add(i);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                dfs(i, nums, map, dp);
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = dp[i];
        }
        return ans;
    }
    
    private void dfs(int root, int[] nums, Map<Integer, List<Integer>> map, int[] dp) {
        if (map.get(root) == null) {
            dp[root] = 1;
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i : map.get(root)) {
            if (dp[i] == -1) {
                dfs(i, nums, map, dp);
            }
            min = Math.min(min, dp[i]);
        }
        if (min == 1) {
            dp[root] = 1;
            return;
        }
        for (int i : map.get(root)) {
            if (nums[i] == min - 1) {
                dp[root] = min;
                return;
            }
        }
        dp[root] = min - 1;
    }
}