class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            for (int j = index; j < nums2.length; j++) {
                int num2 = nums2[j];
                if (num1 <= num2) {
                    max = Math.max(max, j - i);
                    index = j;
                }
            }
        }
        return max;
    }
}