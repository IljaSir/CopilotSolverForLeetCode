class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int newNum = 0;
            while (num > 0) {
                newNum = newNum * 10 + mapping[num % 10];
                num /= 10;
            }
            sorted[i] = newNum;
        }
        Arrays.sort(sorted);
        return sorted;
    }
}