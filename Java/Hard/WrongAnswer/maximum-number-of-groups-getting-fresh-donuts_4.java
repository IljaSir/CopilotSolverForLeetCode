class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int[] count = new int[batchSize];
        int res = 0;
        for (int i : groups) {
            if (i % batchSize == 0) {
                res++;
            } else {
                count[i % batchSize]++;
            }
        }
        for (int i = 1; i < batchSize; i++) {
            int j = batchSize - i;
            if (i == j) {
                res += count[i] / 2;
            } else {
                res += Math.min(count[i], count[j]);
            }
        }
        return res;
    }
}