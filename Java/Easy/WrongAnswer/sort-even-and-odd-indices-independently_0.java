class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[evenIndex++] = nums[i];
            } else {
                odd[oddIndex++] = nums[i];
            }
        }
        Arrays.sort(even, 0, evenIndex);
        Arrays.sort(odd, 0, oddIndex);
        int oddIndex2 = oddIndex - 1;
        int evenIndex2 = evenIndex - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even[evenIndex2--];
            } else {
                nums[i] = odd[oddIndex2--];
            }
        }
        return nums;
    }
}