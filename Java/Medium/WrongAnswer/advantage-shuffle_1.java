class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int index = binarySearch(nums1, nums2[i]);
            res[i] = nums1[index];
            nums1[index] = -1;
        }
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) {
                while (nums1[j] == -1) {
                    j++;
                }
                res[i] = nums1[j];
                j++;
            }
        }
        return res;
    }
    
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == nums.length) {
            left = 0;
        }
        return left;
    }
}