class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[evenCount++] = nums[i];
            } else {
                odd[oddCount++] = nums[i];
            }
        }
        Arrays.sort(odd, 0, oddCount);
        Arrays.sort(even, 0, evenCount);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even[--evenCount];
            } else {
                nums[i] = odd[--oddCount];
            }
        }
        return nums;
    }
}