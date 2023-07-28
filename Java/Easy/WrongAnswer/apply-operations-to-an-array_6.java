class Solution {
    public int[] applyOperations(int[] nums) {
        
        int[] result = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                result[j++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(result[i] == result[i + 1]) {
                result[i] = result[i] * 2;
                result[i + 1] = 0;
            }
        }
        j = 0;
        int[] finalResult = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(result[i] != 0) {
                finalResult[j++] = result[i];
            }
        }
        return finalResult;
    }
}