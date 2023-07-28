class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = forts[i];
            if (i > 0 && left[i] != -1 && left[i - 1] != -1) {
                left[i] += left[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = forts[i];
            if (i < n - 1 && right[i] != -1 && right[i + 1] != -1) {
                right[i] += right[i + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == -1) {
                int cur = 0;
                if (i > 0 && left[i - 1] != -1) {
                    cur += left[i - 1];
                }
                if (i < n - 1 && right[i + 1] != -1) {
                    cur += right[i + 1];
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}