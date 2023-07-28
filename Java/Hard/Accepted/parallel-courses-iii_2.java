class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            int prevCourse = relation[0] - 1;
            int nextCourse = relation[1] - 1;
            graph.get(prevCourse).add(nextCourse);
            indegree[nextCourse]++;
        }
        int[] dp = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                dp[nextCourse] = Math.max(dp[nextCourse], dp[course] + time[course]);
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i] + time[i]);
        }
        return ans;
    }
}