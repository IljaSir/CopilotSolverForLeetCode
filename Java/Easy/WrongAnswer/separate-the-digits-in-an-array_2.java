class Solution {
    public int[] separateDigits(int[] nums) {
        
        int[] result = new int[nums.length * 5];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > 0) {
                result[index++] = num % 10;
                num /= 10;
            }
        }
        return result;
    }
}