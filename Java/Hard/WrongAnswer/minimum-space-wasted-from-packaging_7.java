class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        Arrays.sort(packages);
        for (int[] box : boxes) {
            Arrays.sort(box);
        }
        long minWasted = Long.MAX_VALUE;
        long total = 0;
        for (int packageSize : packages) {
            total += packageSize;
        }
        for (int[] box : boxes) {
            if (box[box.length - 1] < packages[packages.length - 1]) {
                continue;
            }
            int i = 0;
            long wasted = 0;
            for (int boxSize : box) {
                while (i < packages.length && packages[i] <= boxSize) {
                    i++;
                }
                wasted += (long) (i) * boxSize;
            }
            minWasted = Math.min(minWasted, wasted - total);
        }
        return minWasted == Long.MAX_VALUE ? -1 : (int) (minWasted % (1000000007));
    }
}