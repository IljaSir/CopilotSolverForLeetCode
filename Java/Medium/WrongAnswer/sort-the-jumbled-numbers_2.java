class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = getMappedValue(mapping, nums[i]);
        }
        Arrays.sort(result);
        return result;
    }
    private int getMappedValue(int[] mapping, int num) {
        int result = 0;
        int base = 1;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            result += base * mapping[digit];
            base *= 10;
        }
        return result;
    }
}