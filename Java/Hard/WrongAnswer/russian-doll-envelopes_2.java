class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int i = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = envelope[1];
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}