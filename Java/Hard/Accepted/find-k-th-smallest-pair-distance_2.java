class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int m = (l + r) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > m) {
                    left++;
                }
                count += right - left;
            }
            if (count >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}