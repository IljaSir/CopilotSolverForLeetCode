class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int n = nums.length / 2;
        int[] result = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int freq = nums[2 * i];
            int val = nums[2 * i + 1];
            for (int j = 0; j < freq; j++) {
                result[k++] = val;
            }
        }
        return result;
    }
}