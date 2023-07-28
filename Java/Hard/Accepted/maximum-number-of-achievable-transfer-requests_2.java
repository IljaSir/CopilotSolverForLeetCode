class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int m = requests.length;
        int ans = 0;
        for (int i = 0; i < (1 << m); i++) {
            int[] cnt = new int[n];
            int res = 0;
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    cnt[requests[j][0]]--;
                    cnt[requests[j][1]]++;
                    res++;
                }
            }
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (cnt[j] != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
}