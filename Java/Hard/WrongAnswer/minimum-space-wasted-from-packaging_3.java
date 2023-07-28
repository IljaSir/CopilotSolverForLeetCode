class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        Arrays.sort(packages);
        int n = packages.length;
        int m = boxes.length;
        long[] prefix = new long[n];
        prefix[0] = packages[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + packages[i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.sort(boxes[i]);
            if (boxes[i][boxes[i].length - 1] < packages[n - 1]) {
                continue;
            }
            long wasted = 0;
            int j = 0;
            for (int k = 0; k < boxes[i].length; k++) {
                while (j < n && packages[j] <= boxes[i][k]) {
                    j++;
                }
                if (j > 0) {
                    wasted += (long) boxes[i][k] * j - prefix[j - 1];
                }
            }
            res = Math.min(res, wasted);
        }
        return res == Long.MAX_VALUE ? -1 : (int) (res % ((long) 1e9 + 7));
    }
}