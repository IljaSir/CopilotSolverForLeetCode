class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = cardPoints[0];
        right[n-1] = cardPoints[n-1];
        for(int i=1; i<n; i++){
            left[i] = left[i-1] + cardPoints[i];
            right[n-1-i] = right[n-i] + cardPoints[n-1-i];
        }
        int max = 0;
        for(int i=0; i<=k; i++){
            int l = i-1 >= 0 ? left[i-1] : 0;
            int r = n-i-1 >= 0 ? right[n-i-1] : 0;
            max = Math.max(max, l+r);
        }
        return max;
    }
}