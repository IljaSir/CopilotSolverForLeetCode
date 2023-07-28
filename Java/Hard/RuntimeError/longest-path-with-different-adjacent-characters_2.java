class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            if (parent[i] != -1) {
                graph.get(parent[i]).add(i);
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = n - 1; i >= 0; i--) {
            int max1 = 0, max2 = 0;
            for (int j : graph.get(i)) {
                if (s.charAt(j) != s.charAt(i)) {
                    if (dp[j] > max1) {
                        max2 = max1;
                        max1 = dp[j];
                    } else if (dp[j] > max2) {
                        max2 = dp[j];
                    }
                }
            }
            dp[i] += max1;
            res = Math.max(res, max1 + max2 + 1);
        }
        return res;
    }
}