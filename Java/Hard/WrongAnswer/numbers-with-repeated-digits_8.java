class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        int res = 0;
        int len = 0;
        int[] dp = new int[10];
        int[] num = new int[10];
        int tmp = n;
        while (tmp > 0) {
            num[len++] = tmp % 10;
            tmp /= 10;
        }
        dp[0] = 1;
        for (int i = 1; i <= 9; i++) {
            dp[i] = dp[i - 1] * i;
        }
        for (int i = len - 1; i >= 0; i--) {
            int[] map = new int[10];
            for (int j = i + 1; j < len; j++) {
                map[num[j]] = 1;
            }
            int cnt = 0;
            for (int j = i == len - 1 ? 1 : 0; j < num[i]; j++) {
                if (map[j] == 0) {
                    cnt++;
                }
            }
            res += cnt * dp[9 - i];
            if (map[num[i]] == 1) {
                break;
            }
            map[num[i]] = 1;
            if (i == 0) {
                res++;
            }
        }
        return n - res;
    }
}