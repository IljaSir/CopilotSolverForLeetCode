class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + cardPoints[i];
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, preSum[i] + preSum[n] - preSum[n - k + i]);
        }
        return ans;
    }
}