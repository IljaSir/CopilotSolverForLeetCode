class Solution {
    public boolean canCross(int[] stones) {
        
        int n = stones.length;
        Set<Integer>[] dp = new HashSet[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);
        for (int i = 0; i < n; i++) {
            for (int k : dp[i]) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0) {
                        int pos = stones[i] + step;
                        int next = Arrays.binarySearch(stones, i + 1, n, pos);
                        if (next >= 0) {
                            dp[next].add(step);
                        }
                    }
                }
            }
        }
        return !dp[n - 1].isEmpty();
    }
}