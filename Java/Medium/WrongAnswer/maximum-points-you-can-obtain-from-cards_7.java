class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        int left = 0;
        int right = cardPoints.length - k;
        int min = Integer.MAX_VALUE;
        int cur = 0;
        while (right < cardPoints.length) {
            cur += cardPoints[left++];
            cur += cardPoints[right++];
            min = Math.min(min, cur);
            cur = 0;
        }
        return sum - min;
    }
}