class Solution {
    public int convertTime(String current, String correct) {
        
        int h1 = Integer.parseInt(current.substring(0, 2));
        int m1 = Integer.parseInt(current.substring(3, 5));
        int h2 = Integer.parseInt(correct.substring(0, 2));
        int m2 = Integer.parseInt(correct.substring(3, 5));
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        int diff = t2 - t1;
        int[] dp = new int[diff + 1];
        Arrays.fill(dp, diff + 1);
        dp[0] = 0;
        for (int i = 0; i < diff; i++) {
            if (dp[i] == diff + 1) continue;
            int[] ops = new int[]{1, 5, 15, 60};
            for (int op : ops) {
                if (i + op <= diff) dp[i + op] = Math.min(dp[i + op], dp[i] + 1);
            }
        }
        return dp[diff];
    }
}