class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        int max = 6000;
        int[] dp = new int[max];
        int[] visited = new int[max];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(visited, 0);
        for (int f : forbidden) {
            visited[f] = 1;
        }
        dp[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == x) {
                return dp[cur];
            }
            if (cur + a < max && visited[cur + a] == 0) {
                dp[cur + a] = Math.min(dp[cur + a], dp[cur] + 1);
                q.add(cur + a);
            }
            if (cur - b >= 0 && visited[cur - b] == 0) {
                dp[cur - b] = Math.min(dp[cur - b], dp[cur] + 1);
                q.add(cur - b);
            }
        }
        return -1;
    }
}