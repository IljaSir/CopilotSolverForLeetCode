class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length / 3;
        int[] first = new int[n];
        int[] second = new int[n];
        int[] third = new int[n];
        int i = 0;
        for (int num : nums) {
            if (i < n) {
                first[i] = num;
            } else if (i < 2 * n) {
                second[i - n] = num;
            } else {
                third[i - 2 * n] = num;
            }
            i++;
        }
        Arrays.sort(first);
        Arrays.sort(second);
        Arrays.sort(third);
        int[] firstSum = new int[n + 1];
        int[] secondSum = new int[n + 1];
        int[] thirdSum = new int[n + 1];
        for (i = 1; i <= n; i++) {
            firstSum[i] = firstSum[i - 1] + first[i - 1];
            secondSum[i] = secondSum[i - 1] + second[i - 1];
            thirdSum[i] = thirdSum[i - 1] + third[i - 1];
        }
        long min = Long.MAX_VALUE;
        for (i = 0; i <= n; i++) {
            long current = (long) firstSum[n] - firstSum[i] + secondSum[n] - secondSum[n - i] - (thirdSum[n] - thirdSum[n - i]);
            min = Math.min(min, Math.abs(current));
        }
        return min;
    }
}