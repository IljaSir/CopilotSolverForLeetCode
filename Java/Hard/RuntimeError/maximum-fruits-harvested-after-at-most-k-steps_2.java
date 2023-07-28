class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int[] pos = new int[n];
        int[] amt = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            amt[i] = fruits[i][1];
        }
        int l = startPos;
        int r = startPos;
        int left = 0;
        int right = 0;
        int ans = 0;
        int total = 0;
        int last = -1;
        while (l >= 0 || r < n) {
            if (l >= 0 && (r == n || pos[l] >= pos[r] - k)) {
                if (last != pos[l]) {
                    if (last != -1) {
                        left = right;
                    }
                    last = pos[l];
                    right = 0;
                }
                right += amt[l];
                total += amt[l];
                l--;
            } else {
                if (last != pos[r]) {
                    if (last != -1) {
                        left = right;
                    }
                    last = pos[r];
                    right = 0;
                }
                right += amt[r];
                total += amt[r];
                r++;
            }
            ans = Math.max(ans, left + right);
            if (total > ans) {
                total -= amt[l + 1];
            }
        }
        return ans;
    }
}