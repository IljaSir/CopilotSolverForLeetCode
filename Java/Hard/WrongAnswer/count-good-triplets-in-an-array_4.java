class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] <= nums1[j]) {
                    for (int k = j + 1; k < nums1.length; k++) {
                        if (nums1[j] <= nums1[k] && nums2[i] <= nums2[j] && nums2[j] <= nums2[k]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}