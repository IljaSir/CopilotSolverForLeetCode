class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] sum = new int[n];
        int[] enemy = new int[n];
        int[] friend = new int[n];
        for (int i = 0; i < n; i++) {
            enemy[i] = forts[i] == 0 ? 1 : 0;
            friend[i] = forts[i] == 1 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + enemy[i];
        }
        for (int i = 1; i < n; i++) {
            if (friend[i] == 1) {
                left[i] = sum[i - 1];
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (friend[i] == 1) {
                right[i] = sum[n - 1] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = left[i] + right[i];
            if (friend[i] == 1) {
                cur--;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}