class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] indegree = new int[n];
        int[] dp = new int[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : relations) {
            adj[r[0] - 1].add(r[1] - 1);
            indegree[r[1] - 1]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = time[i];
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nei : adj[node]) {
                indegree[nei]--;
                dp[nei] = Math.max(dp[nei], dp[node] + time[nei]);
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}