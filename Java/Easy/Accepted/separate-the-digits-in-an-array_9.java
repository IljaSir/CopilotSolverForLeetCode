class Solution {
    public int[] separateDigits(int[] nums) {
        
        int[] result = new int[0];
        for (int i = 0; i < nums.length; i++) {
            int digit = (int) (Math.log10(nums[i])) + 1;
            int[] temp = new int[result.length + digit];
            for (int j = 0; j < result.length; j++) {
                temp[j] = result[j];
            }
            for (int j = temp.length - 1; j >= temp.length - digit; j--) {
                temp[j] = nums[i] % 10;
                nums[i] = nums[i] / 10;
            }
            result = temp;
        }
        return result;
    }
}