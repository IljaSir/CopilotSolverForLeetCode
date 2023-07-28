class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int i = 1; i < n; i++)
            adj.get(parent[i]).add(i);
        int[] res = new int[1];
        dfs(adj, s, 0, res);
        return res[0];
    }
    
    private int[] dfs(List<List<Integer>> adj, String s, int u, int[] res) {
        int[] dp = new int[26];
        for(int v : adj.get(u)) {
            int[] next = dfs(adj, s, v, res);
            for(int i = 0; i < 26; i++)
                dp[i] = Math.max(dp[i], next[i]);
        }
        dp[s.charAt(u) - 'a']++;
        for(int i = 0; i < 26; i++)
            res[0] = Math.max(res[0], dp[i]);
        return dp;
    }
}