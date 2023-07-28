class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] result = new int[nums.length];
        int[] count = new int[nums.length + 1];
        for (int[] operation : operations) {
            int index = operation[0];
            int value = operation[1];
            count[index - 1]--;
            count[value]++;
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (i < nums.length) {
                result[i] = nums[i] + sum;
            }
        }
        return result;
    }
}