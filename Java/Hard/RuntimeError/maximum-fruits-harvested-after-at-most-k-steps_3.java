class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + fruits[i - 1][1];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = startPos, r = startPos;
            int left = k, right = k;
            int sum = 0;
            while (left > 0 || right > 0) {
                if (left > 0) {
                    while (l >= 0 && fruits[l][0] >= fruits[i][0] - left) {
                        l--;
                    }
                    sum += prefix[i + 1] - prefix[l + 1];
                    left = fruits[i][0] - left - fruits[l + 1][0];
                }
                if (right > 0) {
                    while (r < n && fruits[r][0] <= fruits[i][0] + right) {
                        r++;
                    }
                    sum += prefix[r] - prefix[i];
                    right = fruits[r - 1][0] - fruits[i][0] - right;
                }
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}