class Solution {
    public int[] separateDigits(int[] nums) {
        
        int[] result = new int[0];
        for (int num : nums) {
            int count = 0;
            int temp = num;
            while (temp > 0) {
                count++;
                temp /= 10;
            }
            int[] tempResult = new int[result.length + count];
            for (int i = 0; i < result.length; i++) {
                tempResult[i] = result[i];
            }
            for (int i = 0; i < count; i++) {
                tempResult[result.length + i] = num % 10;
                num /= 10;
            }
            result = tempResult;
        }
        return result;
    }
}