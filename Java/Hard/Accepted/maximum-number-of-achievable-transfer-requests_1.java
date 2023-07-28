class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int m = requests.length;
        int ans = 0;
        for (int i = 1; i < (1 << m); i++) {
            int[] cnt = new int[n];
            for (int j = 0; j < m; j++) {
                if (((1 << j) & i) != 0) {
                    cnt[requests[j][0]]--;
                    cnt[requests[j][1]]++;
                }
            }
            if (Arrays.stream(cnt).allMatch(x -> x == 0)) {
                ans = Math.max(ans, Integer.bitCount(i));
            }
        }
        return ans;
    }
}