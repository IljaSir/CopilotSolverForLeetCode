class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int max = 0;
        int[] in = new int[n];
        int[] out = new int[n];
        for (int i = 0; i < requests.length; i++) {
            out[requests[i][0]]++;
            in[requests[i][1]]++;
        }
        for (int i = 0; i < n; i++) {
            max += Math.min(in[i], out[i]);
        }
        return max;
    }
}