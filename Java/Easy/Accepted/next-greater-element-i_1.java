class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                ans[i] = -1;
                continue;
            }
            boolean flag = false;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}