class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n = prizePositions.length;
        int[] left = new int[n], right = new int[n];
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j < n && prizePositions[j] - prizePositions[i] <= k) ++j;
            left[i] = j - i;
            if (i > 0) left[i] = Math.max(left[i], left[i - 1]);
        }
        j = n - 1;
        for (int i = n - 1; i >= 0; --i) {
            while (j >= 0 && prizePositions[i] - prizePositions[j] <= k) --j;
            right[i] = i - j;
            if (i < n - 1) right[i] = Math.max(right[i], right[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) ans = Math.max(ans, left[i] + right[i]);
        return ans;
    }
}