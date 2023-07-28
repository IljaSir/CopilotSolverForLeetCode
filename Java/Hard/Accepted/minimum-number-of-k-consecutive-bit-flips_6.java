class Solution {
    public int minKBitFlips(int[] nums, int k) {
        
        int result = 0;
        int[] flip = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += flip[i];
            if ((sum + nums[i]) % 2 == 0) {
                if (i + k > nums.length) {
                    return -1;
                }
                result++;
                sum++;
                if (i + k < nums.length) {
                    flip[i + k]--;
                }
            }
        }
        return result;
    }
}