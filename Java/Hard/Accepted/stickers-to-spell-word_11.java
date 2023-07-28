class Solution {
    public int minStickers(String[] stickers, String target) {
        
        int n = target.length();
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) {
                continue;
            }
            for (String sticker : stickers) {
                int next = mask;
                for (char letter : sticker.toCharArray()) {
                    for (int i = 0; i < n; i++) {
                        if (((next >> i) & 1) == 0 && target.charAt(i) == letter) {
                            next |= 1 << i;
                            break;
                        }
                    }
                }
                dp[next] = Math.min(dp[next], dp[mask] + 1);
            }
        }
        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }
}