class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        // binary search
        int n = capacity.length;
        int l = 0;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isValid(capacity, rocks, additionalRocks, m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }

    private boolean isValid(int[] capacity, int[] rocks, int additionalRocks, int m) {
        long sum = 0;
        for (int i = 0; i < capacity.length; i++) {
            sum += Math.min(capacity[i], rocks[i] + additionalRocks / (capacity.length - i));
        }
        return sum >= additionalRocks;
    }
}