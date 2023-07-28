class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (nums2[j] != nums1[i]) {
                j++;
            }
            while (j < nums2.length && nums2[j] <= nums1[i]) {
                j++;
            }
            ans[i] = j == nums2.length ? -1 : nums2[j];
        }
        return ans;
    }
}