class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int[] pos = new int[n];
        int[] amount = new int[n];
        for (int i = 0; i < n; ++i) {
            pos[i] = fruits[i][0];
            amount[i] = fruits[i][1];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (Math.abs(pos[i] - startPos) > k) {
                continue;
            }
            int left = Math.max(0, i - k - 1);
            int right = Math.min(n - 1, i + k + 1);
            while (left < n && Math.abs(pos[left] - startPos) > k) {
                ++left;
            }
            while (right >= 0 && Math.abs(pos[right] - startPos) > k) {
                --right;
            }
            if (left > right) {
                continue;
            }
            int sum = 0;
            for (int j = left; j <= right; ++j) {
                sum += amount[j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}