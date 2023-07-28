class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] dp = new int[n];
        int[] in = new int[n];
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
            in[e[0]]++;
            in[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 1) {
                q.offer(i);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (in[v] > 0) {
                    in[v]--;
                    dp[v] = Math.max(dp[v], dp[u] + scores[u]);
                    if (in[v] == 1) {
                        q.offer(v);
                    }
                }
            }
            ans = Math.max(ans, dp[u] + scores[u]);
        }
        return ans;
    }
}