class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        int even = 0;
        int odd = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                result[even++] = nums[i];
            } else {
                result[odd--] = nums[i];
            }
        }
        Arrays.sort(result, 0, even);
        Arrays.sort(result, odd + 1, n);
        return result;
    }
}