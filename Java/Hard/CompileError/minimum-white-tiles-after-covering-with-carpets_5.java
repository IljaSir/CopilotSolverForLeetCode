class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] dp = new int[n];
        int[] sum = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        for (int i = 0; i < n; i++) {
            if (floor.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = i > 0 ? dp[i - 1] + 1 : 1;
            }
            sum[i] = dp[i] + (i > 0 ? sum[i - 1] : 0);
        }
        int l = 0;
        int r = 0;
        while (r < carpetLen - 1) {
            if (floor.charAt(r) == '1') {
                left[r] = r - l + 1;
            } else {
                l = r + 1;
            }
            r++;
        }
        for (int i = carpetLen - 1; i < n; i++) {
            if (floor.charAt(i) == '1') {
                left[i] = i - l + 1;
            } else {
                l = i + 1;
            }
        }
        l = n - 1;
        r = n - 1;
        while (l > n - carpetLen) {
            if (floor.charAt(l) == '1') {
                right[l] = r - l + 1;
            } else {
                r = l - 1;
            }
            l--;
        }
        for (int i = n - carpetLen - 1; i >= 0; i--) {
            if (floor.charAt(i) == '1') {
                right[i] = r - i + 1;
            } else {
                r = i - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            count[i] = (i > 0 ? count[i - 1] : 0) + (floor.charAt(i) == '1' ? 1 : 0);
        }
        for (int i = 0; i < n; i++) {
            int l1 =
    }
}