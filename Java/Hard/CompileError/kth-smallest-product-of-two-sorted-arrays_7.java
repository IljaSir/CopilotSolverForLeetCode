class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        // Binary search for the answer
        long left = (long)nums1[0] * nums2[0];
        long right = (long)nums1[nums1.length-1] * nums2[nums2.length-1];
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessOrEqual(mid, nums1, nums2) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private long countLessOrEqual(long target, int[] nums1, int[] nums2) {
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int index = Arrays.binarySearch(nums2, (int)(target / nums1[i]));
            if (index < 0) {
                index = -(index + 1) - 1;
            } else {
               while (index < nums2.length - 1 && nums2[index1] == nums2[index]) {
                   index++;
                }
            }
            count += index + ;
        }
        return count;
    }
}