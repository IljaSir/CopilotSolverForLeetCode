class Solution {
    public int maxValue(int[][] events, int k) {
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= k; i++) {
            int[] ndp = new int[n + 1];
            int j = 1;
            for (int[] e : events) {
                int l = 1, r = j;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (events[mid - 1][1] < e[0]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ndp[j] = Math.max(ndp[j - 1], dp[l - 1] + e[2]);
                j++;
            }
            dp = ndp;
        }
        return dp[n];
    }
}