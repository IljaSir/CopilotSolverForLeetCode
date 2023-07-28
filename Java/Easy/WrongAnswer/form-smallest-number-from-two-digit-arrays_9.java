class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        //Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        //Check if the first digit of nums1 is less than the first digit of nums2
        if (nums1[0] < nums2[0]) {
            return nums1[0];
        }
        else {
            return nums2[0];
        }
    }
}