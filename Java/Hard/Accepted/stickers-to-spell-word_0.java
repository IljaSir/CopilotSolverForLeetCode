class Solution {
    public int minStickers(String[] stickers, String target) {
        
        int[] dp = new int[1 << target.length()];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (String sticker : stickers) {
                int next = i;
                for (char c : sticker.toCharArray()) {
                    for (int j = 0; j < target.length(); j++) {
                        if (((next >> j) & 1) == 0 && c == target.charAt(j)) {
                            next |= 1 << j;
                            break;
                        }
                    }
                }
                if (dp[next] == -1 || dp[next] > dp[i] + 1) {
                    dp[next] = dp[i] + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }
}