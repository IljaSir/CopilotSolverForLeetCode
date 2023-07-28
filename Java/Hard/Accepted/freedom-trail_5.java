class Solution {
    public int findRotateSteps(String ring, String key) {
        
        int ringLen = ring.length();
        int keyLen = key.length();
        int[][] dp = new int[keyLen][ringLen];
        for (int i = 0; i < keyLen; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < ringLen; i++) {
            if (ring.charAt(i) == key.charAt(0)) {
                dp[0][i] = Math.min(i, ringLen - i) + 1;
            }
        }
        for (int i = 1; i < keyLen; i++) {
            for (int j = 0; j < ringLen; j++) {
                if (ring.charAt(j) == key.charAt(i)) {
                    for (int k = 0; k < ringLen; k++) {
                        if (dp[i - 1][k] != Integer.MAX_VALUE) {
                            int diff = Math.abs(j - k);
                            int step = Math.min(diff, ringLen - diff);
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + step + 1);
                        }
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < ringLen; i++) {
            result = Math.min(result, dp[keyLen - 1][i]);
        }
        return result;
    }
}