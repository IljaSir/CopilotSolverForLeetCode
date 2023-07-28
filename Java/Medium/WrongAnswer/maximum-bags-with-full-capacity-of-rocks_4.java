class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = capacity.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int sum = 0;
        int i = n - 1;
        for (; i >= 0; i--) {
            sum += diff[i];
            if (sum > additionalRocks) {
                break;
            }
        }
        return n - i - 1;
    }
}