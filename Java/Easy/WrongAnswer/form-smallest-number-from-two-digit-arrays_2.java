class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int min1 = 10, min2 = 10;
        for (int i : nums1) {
            min1 = Math.min(min1, i);
        }
        for (int i : nums2) {
            min2 = Math.min(min2, i);
        }
        return min1 * 10 + min2;
    }
}