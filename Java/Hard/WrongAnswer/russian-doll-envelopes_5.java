class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0], b[0]));
        int n = envelopes.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = ans;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < envelopes[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = envelopes[i][1];
            if (left == ans) {
                ans++;
            }
        }
        return ans;
    }
}