class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        Arrays.sort(packages);
        int n = packages.length;
        int m = boxes.length;
        int max = packages[n - 1];
        long[] preSum = new long[n];
        preSum[0] = packages[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + packages[i];
        }
        long ans = Long.MAX_VALUE;
        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < max) {
                continue;
            }
            long cur = 0;
            int j = 0;
            for (int i = 0; i < box.length; i++) {
                while (j < n && packages[j] <= box[i]) {
                    j++;
                }
                if (j == 0) {
                    continue;
                }
                cur += (long) box[i] * j - preSum[j - 1];
            }
            ans = Math.min(ans, cur);
        }
        return ans == Long.MAX_VALUE ? -1 : (int) (ans % (1e9 + 7));
    }
}