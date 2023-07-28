class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                left[i] = forts[i] == 1 ? 1 : 0;
            } else {
                left[i] = forts[i] == 1 ? left[i - 1] + 1 : left[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                right[i] = forts[i] == 1 ? 1 : 0;
            } else {
                right[i] = forts[i] == 1 ? right[i + 1] + 1 : right[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                continue;
            }
            int l = i == 0 ? 0 : left[i - 1];
            int r = i == n - 1 ? 0 : right[i + 1];
            ans = Math.max(ans, l + r);
        }
        return ans;
    }
}