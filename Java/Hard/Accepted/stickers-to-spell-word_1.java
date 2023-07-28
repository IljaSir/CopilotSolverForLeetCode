class Solution {
    public int minStickers(String[] stickers, String target) {
        
        int[] dp = new int[1 << target.length()];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int state = 0; state < dp.length; state++) {
            if (dp[state] == -1) continue;
            for (String sticker : stickers) {
                int now = state;
                for (char letter : sticker.toCharArray()) {
                    for (int i = 0; i < target.length(); i++) {
                        if (((now >> i) & 1) == 1) continue;
                        if (target.charAt(i) == letter) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }
}