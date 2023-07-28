class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int number = 0;
        int[] digits = new int[10];
        for (int i = 0; i < nums1.length; i++) {
            digits[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            digits[nums2[i]] = 1;
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 1) {
                number = number * 10 + i;
            }
        }
        return number;
    }
}