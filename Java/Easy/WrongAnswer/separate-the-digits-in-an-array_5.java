class Solution {
    public int[] separateDigits(int[] nums) {
        
        int[] result = new int[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            while (number > 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[count] = number % 10;
                number /= 10;
                count++;
            }
        }
        return result;
    }
}