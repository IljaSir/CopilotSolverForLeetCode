class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i];
        }
        int[] result = new int[count];
        for (int i = 0, j = 0; i < nums.length; i += 2) {
            while (nums[i]-- > 0) {
                result[j++] = nums[i + 1];
            }
        }
        return result;
    }
}