class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        int n = packages.length;
        int m = boxes.length;
        long ans = Long.MAX_VALUE;
        long sum = 0;
        long mod = (long)1e9 + 7;
        Arrays.sort(packages);
        for (int i = 0; i < n; i++) {
            sum += packages[i];
        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(boxes[i]);
            if (boxes[i][boxes[i].length - 1] < packages[n - 1]) {
                continue;
            }
            int j = 0;
            long cur = 0;
            for (int k = 0; k < boxes[i].length; k++) {
                while (j < n && packages[j] <= boxes[i][k]) {
                    cur += boxes[i][k] - packages[j];
                    j++;
                }
            }
            ans = Math.min(ans, cur);
        }
        return ans == Long.MAX_VALUE ? -1 : (int)(ans % mod);
    }
}