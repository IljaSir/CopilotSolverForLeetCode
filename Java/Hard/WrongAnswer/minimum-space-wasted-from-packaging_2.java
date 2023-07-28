class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        Arrays.sort(packages);
        int n = packages.length;
        int mod = 1000000007;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += packages[i];
        }
        long res = Long.MAX_VALUE;
        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < packages[n - 1]) {
                continue;
            }
            long cur = 0;
            int j = 0;
            for (int k = 0; k < box.length; k++) {
                while (j < n && packages[j] <= box[k]) {
                    cur += box[k] - packages[j];
                    j++;
                }
            }
            res = Math.min(res, cur);
        }
        return res == Long.MAX_VALUE ? -1 : (int) ((res - sum) % mod);
    }
}