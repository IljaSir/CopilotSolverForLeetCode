class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] res = new int[n];
        Arrays.sort(nums1);
        for (int i = 0; i < n; i++) {
            int index = binarySearch(nums1, nums2[i]);
            res[i] = nums1[index];
            nums1[index] = -1;
        }
        return res;
    }
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] > target) {
            return l;
        } else {
            return 0;
        }
    }
}