class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int sum = 0, left = 0, n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[k - i - 1];
            sum += cardPoints[n - i - 1];
            max = Math.max(max, sum);
        }
        return max;
    }
}