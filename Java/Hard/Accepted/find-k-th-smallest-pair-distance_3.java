class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) left++;
                count += right - left;
            }
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}