class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums1[i];
            int j = 0;
            for (; j < nums2.length; j++) {
                if (nums2[j] == num) {
                    break;
                }
            }
            for (; j < nums2.length; j++) {
                if (nums2[j] > num) {
                    ans[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}