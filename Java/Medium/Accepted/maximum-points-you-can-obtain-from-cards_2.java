class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + cardPoints[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = right[i + 1] + cardPoints[i];
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, left[i] + right[n - k + i]);
        }
        return ans;
    }
}