class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        int xor = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                xor ^= num1 ^ num2;
            }
        }
        return xor;
    }
}