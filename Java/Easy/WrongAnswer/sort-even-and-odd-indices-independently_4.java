class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int[] result = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[evenIndex++] = nums[i];
            } else {
                result[oddIndex--] = nums[i];
            }
        }
        Arrays.sort(result, 0, evenIndex);
        Arrays.sort(result, oddIndex + 1, nums.length);
        return result;
    }
}