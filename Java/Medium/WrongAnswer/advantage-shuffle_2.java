class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int index = binarySearch(nums1, nums2[i]);
            result[i] = nums1[index];
            nums1[index] = -1;
            Arrays.sort(nums1);
        }
        return result;
    }
    
    private int binarySearch(int[] nums1, int target) {
        int l = 0;
        int r = nums1.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums1[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (l >= nums1.length) {
            l = 0;
        }
        return l;
    }
}