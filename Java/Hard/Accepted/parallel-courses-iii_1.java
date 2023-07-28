class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : relations) {
            indegree[r[1] - 1]++;
            graph.get(r[0] - 1).add(r[1] - 1);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = time[i];
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[node] + time[next]);
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        int res = 0;
        for (int d : dp) {
            res = Math.max(res, d);
        }
        return res;
    }
}