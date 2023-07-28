class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = i;
            while (j < nums2.length && nums1[i] <= nums2[j]) {
                j++;
            }
            result = Math.max(result, j - i - 1);
        }
        return result;
    }
}