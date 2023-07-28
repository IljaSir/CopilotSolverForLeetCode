class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int[] result = new int[nums.length];
        int odd = 1;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[even] = nums[i];
                even += 2;
            } else {
                result[odd] = nums[i];
                odd += 2;
            }
        }
        return result;
    }
}