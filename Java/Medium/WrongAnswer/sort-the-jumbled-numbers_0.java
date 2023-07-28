class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map(mapping, nums[i]);
        }
        Arrays.sort(result);
        return result;
    }
    public int map(int[] mapping, int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + mapping[num % 10];
            num /= 10;
        }
        return result;
    }
}