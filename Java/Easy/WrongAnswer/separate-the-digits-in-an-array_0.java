class Solution {
    public int[] separateDigits(int[] nums) {
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (temp > 0) {
                count++;
                temp /= 10;
            }
        }
        int[] result = new int[count];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (temp > 0) {
                result[j++] = temp % 10;
                temp /= 10;
            }
        }
        return result;
    }
}