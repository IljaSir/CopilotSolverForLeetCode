class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        int m = edges.length();
        int[] indegree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj[from].add(to);
            indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] colorCount = new int[26];
        int[][] dp = new int[n][26];
        int[] visited = new int[n];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = 1;
            colorCount[colors.charAt(u) - 'a']++;
            for (int i = 0; i < 26; i++) {
                dp[u][i] = colorCount[i];
            }
            for (int v : adj[u]) {
                for (int i = 0; i < 26; i++) {
                    dp[v][i] = Math.max(dp[v][i], dp[u][i]);
                }
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
            colorCount[colors.charAt(u) - 'a']--;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return -1;
            }
            for (int j = 0; j < 26; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}