class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        if (n == 0 || relations.length == 0) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int[] relation: relations) {
            int prev = relation[0], next = relation[1];
            indegree[next]++;
            graph.computeIfAbsent(prev, k -> new ArrayList<>()).add(next);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i] = time[i - 1];
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (graph.containsKey(course)) {
                for (int next: graph.get(course)) {
                    indegree[next]--;
                    dp[next] = Math.max(dp[next], dp[course] + time[next - 1]);
                    if (indegree[next] == 0) queue.offer(next);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}