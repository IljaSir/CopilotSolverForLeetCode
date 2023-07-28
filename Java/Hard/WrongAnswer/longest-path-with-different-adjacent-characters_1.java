class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        int[] ans = new int[1];
        dfs(0, adj, s, ans);
        return ans[0];
    }
    private int[] dfs(int u, List<List<Integer>> adj, String s, int[] ans) {
        int[] cnt = new int[26];
        for (int v : adj.get(u)) {
            int[] sub = dfs(v, adj, s, ans);
            for (int i = 0; i < 26; i++) {
                cnt[i] = Math.max(cnt[i], sub[i]);
            }
        }
        int c = s.charAt(u) - 'a';
        ans[0] = Math.max(ans[0], cnt[c] + 1);
        cnt[c] += 1;
        return cnt;
    }
}