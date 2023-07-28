class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int j = 0; j < m; j++) {
            int[] ndp = new int[n];
            for (int i = 0; i < n; i++) {
                ndp[i] = dp[i];
                if (ndp[i] == 0) continue;
                for (int k = i + 1; k < n; k++) {
                    if (strs[i].charAt(j) > strs[k].charAt(j)) {
                        ndp[i] = 0;
                        break;
                    }
                }
                for (int k = 0; k < i; k++) {
                    if (strs[i].charAt(j) < strs[k].charAt(j)) {
                        ndp[i] = 0;
                        break;
                    }
                }
            }
            if (Arrays.stream(ndp).sum() == 0) {
                res++;
            } else {
                dp = ndp;
            }
        }
        return res;
    }
}