class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int[] grumpyCount = new int[n];
        int maxGrumpy = 0;
        int grumpySum = 0;
        for (int i = 0; i < n; i++) {
            grumpySum += grumpy[i] * customers[i];
            grumpyCount[i] = grumpySum;
            if (i >= minutes) {
                grumpySum -= grumpy[i - minutes] * customers[i - minutes];
            }
            maxGrumpy = Math.max(maxGrumpy, grumpyCount[i]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        return total + maxGrumpy;
    }
}