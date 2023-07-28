class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        int i = 0, j = 0;
        int min = -1;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                if(min == -1) {
                    min = nums1[i];
                } else {
                    min = Math.min(min, nums1[i]);
                }
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}