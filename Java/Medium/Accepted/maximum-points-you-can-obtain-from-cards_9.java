class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int max = 0;
        int j = cardPoints.length - 1;
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += cardPoints[i];
        }
        max = temp;
        for (int i = 0; i < k; i++) {
            temp -= cardPoints[k - 1 - i];
            temp += cardPoints[j - i];
            max = Math.max(max, temp);
        }
        return max;
    }
}