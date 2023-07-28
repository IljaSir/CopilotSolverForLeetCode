class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int[] envelope : envelopes) {
            int i = Arrays.binarySearch(dp, 0, ans, envelope[1]);
            if (i < 0) i = -(i + 1);
            dp[i] = envelope[1];
            if (i == ans) ans++;
        }
        return ans;
    }
}