class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int max = 0;
        for (int i = 0; i < (1 << requests.length); i++) {
            int[] count = new int[n];
            for (int j = 0; j < requests.length; j++) {
                if (((1 << j) & i) != 0) {
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
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
                max = Math.max(max, Integer.bitCount(i));
            }
        }
        return max;
    }
}