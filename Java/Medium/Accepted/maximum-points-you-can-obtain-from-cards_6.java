class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int len = cardPoints.length;
        int[] left = new int[k + 1];
        int[] right = new int[k + 1];
        for (int i = 0; i < k; i++) {
            left[i + 1] = left[i] + cardPoints[i];
            right[i + 1] = right[i] + cardPoints[len - i - 1];
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, left[i] + right[k - i]);
        }
        return ans;
    }
}