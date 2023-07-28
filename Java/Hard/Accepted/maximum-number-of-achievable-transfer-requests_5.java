class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int max = 0;
        for (int i = 0; i < 1 << requests.length; i++) {
            int[] count = new int[n];
            int res = 0;
            for (int j = 0; j < requests.length; j++) {
                if ((i & (1 << j)) != 0) {
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
                    res++;
                }
            }
            boolean ok = true;
            for (int c : count) {
                if (c != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                max = Math.max(max, res);
            }
        }
        return max;
    }
}