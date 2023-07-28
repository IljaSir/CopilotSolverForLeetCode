class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        Arrays.sort(capacity);
        Arrays.sort(rocks);
        int l = 0, r = capacity.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (check(capacity, rocks, m, additionalRocks)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
    
    private boolean check(int[] capacity, int[] rocks, int m, int additionalRocks) {
        int n = capacity.length;
        int l = n - m - 1;
        int r = n - 1;
        while (l < r) {
            int sum = rocks[l] + rocks[r];
            if (sum < capacity[m]) {
                additionalRocks -= capacity[m] - sum;
                l++;
                r--;
            } else {
                r--;
            }
            if (additionalRocks < 0) {
                return false;
            }
        }
        return true;
    }
}