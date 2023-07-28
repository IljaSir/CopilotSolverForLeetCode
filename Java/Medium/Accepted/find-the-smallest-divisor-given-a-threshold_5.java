class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int lo = 1, hi = 1000000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= threshold) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}