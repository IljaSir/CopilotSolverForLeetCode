class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int n = nums.length;
        int len = 0;
        for (int i = 0; i < n; i += 2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int idx = 0;
        for (int i = 0; i < n; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq-- > 0) {
                res[idx++] = val;
            }
        }
        return res;
    }
}