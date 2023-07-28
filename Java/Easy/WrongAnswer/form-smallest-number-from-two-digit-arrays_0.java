class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[nums1.length + i] = nums2[i];
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] * Math.pow(10, i);
        }
        return result;
    }
}