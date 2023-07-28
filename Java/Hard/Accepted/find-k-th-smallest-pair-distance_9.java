class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length, lo = 0, hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mi = lo + hi >>> 1, count = 0, left = 0;
            for (int right = 0; right < n; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}