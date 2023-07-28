class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long res = 0;
        int left = 0;
        int right = 0;
        int min = 0;
        int max = 0;
        while (right < nums.length) {
            while (right < nums.length && min <= maxK && max >= minK) {
                if (nums[right] < minK) {
                    min++;
                }
                if (nums[right] > maxK) {
                    max++;
                }
                right++;
            }
            res += (right - left) * (right - left + 1) / 2;
            if (nums[left] < minK) {
                min--;
            }
            if (nums[left] > maxK) {
                max--;
            }
            left++;
        }
        return res;
    }
}