class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int max = 0;
        int n = events.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < events[i][0]) {
                max = Math.max(max, pq.poll()[2]);
            }
            dp[i] = max + events[i][2];
            if (i < n - 1) {
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
            pq.offer(events[i]);
        }
        return dp[n - 1];
    }
}