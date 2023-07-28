class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int j = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(res, j, j + nums[i], nums[i + 1]);
            j += nums[i];
        }
        return res;
    }
}