class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + fruits[i][1];
        }
        int ans = 0;
        int i = startPos, j = startPos;
        while (i >= 0 || j < n) {
            if (i >= 0 && j < n) {
                int l = fruits[i][0], r = fruits[j][0];
                if (r - l <= k) {
                    ans = Math.max(ans, prefix[j + 1] - prefix[i]);
                    j++;
                } else {
                    i--;
                }
            } else if (i >= 0) {
                int l = fruits[i][0], r = fruits[j - 1][0];
                if (r - l <= k) {
                    ans = Math.max(ans, prefix[j] - prefix[i]);
                    i--;
                } else {
                    break;
                }
            } else {
                int l = fruits[i + 1][0], r = fruits[j][0];
                if (r - l <= k) {
                    ans = Math.max(ans, prefix[j + 1] - prefix[i]);
                    j++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}