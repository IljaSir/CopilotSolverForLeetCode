class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int f : forbidden) {
            forbiddenSet.add(f);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur + a == x || cur - b == x) {
                return dp[cur] + 1;
            }
            if (cur + a < x && !forbiddenSet.contains(cur + a) && dp[cur + a] == Integer.MAX_VALUE) {
                dp[cur + a] = dp[cur] + 1;
                queue.offer(cur + a);
            }
            if (cur - b >= 0 && !forbiddenSet.contains(cur - b) && dp[cur - b] == Integer.MAX_VALUE) {
                dp[cur - b] = dp[cur] + 1;
                queue.offer(cur - b);
            }
        }
        return -1;
    }
}