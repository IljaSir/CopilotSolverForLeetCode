class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        int[] inDegree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            inDegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] dp = new int[n];
        int[] freq = new int[26];
        int max = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            freq[colors.charAt(u) - 'a']++;
            for (int v : adj[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
                for (int i = 0; i < 26; i++) {
                    dp[v] = Math.max(dp[v], dp[u] + freq[i]);
                }
                max = Math.max(max, dp[v]);
            }
            freq[colors.charAt(u) - 'a']--;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] > 0) {
                return -1;
            }
        }
        return max;
    }
}