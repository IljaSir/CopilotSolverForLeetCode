class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        // Build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] relation: relations) {
            graph.get(relation[0] - 1).add(relation[1] - 1);
        }
        // Topological sort
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int next: graph.get(i)) {
                inDegree[next]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] dp = new int[n];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next: graph.get(cur)) {
                inDegree[next]--;
                dp[next] = Math.max(dp[next], dp[cur] + time[cur]);
                if (inDegree[next] == 0) {
                    queue.offer(next);
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