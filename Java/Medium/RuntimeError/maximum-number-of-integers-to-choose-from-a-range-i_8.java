class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + i;
        }
        int[] bannedSums = new int[banned.length + 1];
        bannedSums[0] = 0;
        for (int i = 0; i < banned.length; i++) {
            bannedSums[i + 1] = bannedSums[i] + banned[i];
        }
        int min = 0;
        int max = n;
        while (min < max) {
            int mid = (min + max + 1) / 2;
            if (sums[mid] - bannedSums[mid] <= maxSum) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}