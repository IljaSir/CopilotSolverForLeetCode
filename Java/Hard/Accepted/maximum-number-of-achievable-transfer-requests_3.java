class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int max = 0;
        for (int i = 0; i < (1 << requests.length); i++) {
            int[] count = new int[n];
            int c = 0;
            for (int j = 0; j < requests.length; j++) {
                if (((i >> j) & 1) == 1) {
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
                    c++;
                }
            }
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (count[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                max = Math.max(max, c);
            }
        }
        return max;
    }
}