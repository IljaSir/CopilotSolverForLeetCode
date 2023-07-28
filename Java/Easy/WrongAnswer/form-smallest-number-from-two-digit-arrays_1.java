class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int num = Integer.parseInt("" + nums1[i] + nums2[j]);
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }
}