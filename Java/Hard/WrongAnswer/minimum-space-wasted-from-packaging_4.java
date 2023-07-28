class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        int mod = 1000000007;
        int n = packages.length;
        int m = boxes.length;
        Arrays.sort(packages);
        int[][] sortedBoxes = new int[m][];
        for (int i = 0; i < m; i++) {
            sortedBoxes[i] = boxes[i];
            Arrays.sort(sortedBoxes[i]);
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += packages[i];
        }
        long minWasted = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            long wasted = 0;
            int j = 0;
            int k = 0;
            while (j < n && k < sortedBoxes[i].length) {
                if (sortedBoxes[i][k] >= packages[j]) {
                    wasted += (long) (sortedBoxes[i][k] - packages[j]);
                    j++;
                } else {
                    k++;
                }
            }
            if (j < n) {
                wasted = Long.MAX_VALUE;
            }
            minWasted = Math.min(minWasted, wasted);
        }
        if (minWasted == Long.MAX_VALUE) {
            return -1;
        }
        return (int) ((minWasted - total) % mod);
    }
}