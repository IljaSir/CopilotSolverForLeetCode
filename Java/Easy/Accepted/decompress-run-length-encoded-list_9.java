class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int l = nums.length;
        int freq = 0, val = 0;
        int total = 0;
        for (int i = 0; i < l; i += 2) {
            freq = nums[i];
            val = nums[i + 1];
            total += freq;
        }
        int[] result = new int[total];
        int index = 0;
        for (int i = 0; i < l; i += 2) {
            freq = nums[i];
            val = nums[i + 1];
            while (freq > 0) {
                result[index++] = val;
                freq--;
            }
        }
        return result;
    }
}