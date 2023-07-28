class Solution {
    public int[] separateDigits(int[] nums) {
        
        int[] result = new int[0];
        for(int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            int len = 0;
            while(tmp > 0) {
                tmp /= 10;
                len++;
            }
            int[] tmpResult = new int[result.length + len];
            for(int j = 0; j < result.length; j++) {
                tmpResult[j] = result[j];
            }
            tmp = nums[i];
            for(int j = tmpResult.length - 1; j >= tmpResult.length - len; j--) {
                tmpResult[j] = tmp % 10;
                tmp /= 10;
            }
            result = tmpResult;
        }
        return result;
    }
}