class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int index = findIndex(nums1, nums2[i]);
            ans[i] = nums1[index];
            nums1[index] = -1;
        }
        return ans;
    }

    private int findIndex(int[] nums1, int target) {
        int start = 0, end = nums1.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums1[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (nums1[mid] <= target) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != -1) {
                    return i;
                }
            }
        }
        return mid;
    }
}