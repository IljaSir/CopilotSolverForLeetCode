class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n = prizePositions.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && prizePositions[j] - prizePositions[i] <= k) {
                j++;
            }
            left[i] = j - i;
            i++;
        }
        i = n - 1;
        j = n - 1;
        while (i >= 0) {
            while (j >= 0 && prizePositions[i] - prizePositions[j] <= k) {
                j--;
            }
            right[i] = i - j;
            i--;
        }
        int ans = 0;
        for (i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;
    }
}