class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int mapped = 0;
            while(num > 0) {
                mapped = mapped * 10 + mapping[num % 10];
                num /= 10;
            }
            result[i] = mapped;
        }
        Arrays.sort(result);
        return result;
    }
}