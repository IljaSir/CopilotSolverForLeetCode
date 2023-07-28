class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.get(prev).add(next);
            indegree[next]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] dp = new int[n];
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                dp[next] = Math.max(dp[next], dp[cur] + time[cur]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i] + time[i]);
        }
        return res;
    }
}