class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int len = nums.length;
        int[] count = new int[32];
        for(int i = 0; i < len; i++){
            int num = nums[i];
            for(int j = 0; j < 32; j++){
                count[j] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            res += count[i] * (len - count[i]);
        }
        return res;
    }
}