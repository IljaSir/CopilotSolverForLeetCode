class Solution {
    public int[] separateDigits(int[] nums) {
        
        int[] result = new int[nums.length * 5];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] digits = getDigits(nums[i]);
            for (int j = 0; j < digits.length; j++) {
                result[index] = digits[j];
                index++;
            }
        }
        return result;
    }
    
    public int[] getDigits(int num) {
        int[] result = new int[5];
        int index = 0;
        while (num > 0) {
            result[index] = num % 10;
            num /= 10;
            index++;
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}