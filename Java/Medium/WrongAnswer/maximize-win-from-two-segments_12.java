class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n = prizePositions.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int i = 0, j = 0;
        for (int pos : prizePositions) {
            while (i < n && prizePositions[i] - pos <= k) {
                i++;
            }
            left[j] = i - j;
            j++;
        }
        i = n - 1;
        j = n - 1;
        for (int pos : prizePositions) {
            while (i >= 0 && pos - prizePositions[i] <= k) {
                i--;
            }
            right[j] = j - i;
            j--;
        }
        int max = 0;
        for (int l = 0; l < n; l++) {
            max = Math.max(max, left[l] + right[l]);
        }
        return max;
    }
}