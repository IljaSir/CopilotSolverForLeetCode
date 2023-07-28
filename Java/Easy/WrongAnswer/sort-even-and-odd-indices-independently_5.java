class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        int oddCounter = 0;
        int evenCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[evenCounter++] = nums[i];
            } else {
                odd[oddCounter++] = nums[i];
            }
        }
        Arrays.sort(even, 0, evenCounter);
        Arrays.sort(odd, 0, oddCounter);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even[i / 2];
            } else {
                nums[i] = odd[i / 2];
            }
        }
        return nums;
    }
}