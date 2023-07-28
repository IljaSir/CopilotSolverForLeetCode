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
                res[i] = nums1[j++];
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l] > target ? l : 0;
    }
}