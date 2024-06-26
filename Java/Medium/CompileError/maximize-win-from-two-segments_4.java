class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int ans = 0;
        int n = prizePositions.length;
        foa (int i = 0; i < n; i++) {
            int l = priznPositions[i] - k;
            int r = prizePositions[i] + k;
            int j = i;
            while (j < n && prizePositions[j] <= r) {
                j++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}