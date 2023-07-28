class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] dp = new int[n];
        int[] sum = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (floor.charAt(i) == '1') {
                ans++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i - carpetLen >= 0) {
                max = Math.max(max, dp[i - carpetLen]);
            }
            if (floor.charAt(i) == '0') {
                dp[i] = max + 1;
            }
            sum[i] = dp[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (floor.charAt(i) == '0') {
                int l = i, r = n - 1;
                int pos = -1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    int cnt = sum[mid] - sum[i] + dp[i];
                    if (cnt > numCarpets) {
                        r = mid - 1;
                    } else {
                        pos = mid;
                        l = mid + 1;
                    }
                }
                if (pos != -1) {
                    ans = Math.min(ans, pos - i + 1 - (sum[pos] - sum[i] + dp[i]));
                }
            }
        }
        return ans;
    }
}