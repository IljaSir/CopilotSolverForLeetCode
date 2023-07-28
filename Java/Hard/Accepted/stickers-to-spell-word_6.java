class Solution {
    public int minStickers(String[] stickers, String target) {
        
        int n = target.length();
        int[] dp = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < (1 << n); i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (String sticker : stickers) {
                int j = i;
                for (char c : sticker.toCharArray()) {
                    for (int k = 0; k < n; k++) {
                        if (((j >> k) & 1) == 0 && target.charAt(k) == c) {
                            j |= 1 << k;
                            break;
                        }
                    }
                }
                if (dp[j] == -1 || dp[j] > dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}