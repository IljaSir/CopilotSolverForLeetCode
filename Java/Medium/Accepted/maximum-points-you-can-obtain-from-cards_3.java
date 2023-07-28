class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int[] left = new int[n];
        left[0] = cardPoints[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + cardPoints[i];
        }
        int[] right = new int[n];
        right[n - 1] = cardPoints[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + cardPoints[i];
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            int score = 0;
            if (i > 0) {
                score += left[i - 1];
            }
            if (i < k) {
                score += right[n - k + i];
            }
            max = Math.max(max, score);
        }
        return max;
    }
}