class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int m = requests.length;
        int max = 0;
        for (int i = 0; i < 1 << m; i++) {
            int[] count = new int[n];
            int res = 0;
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (count[j] == 0) {
                    res++;
                }
            }
            max = Math.max(max, res);
        }
        return max;
    }
}