class Solution {
    public int subsetXORSum(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                result[j] ^= result[j + 1];
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += result[i];
        }
        return sum;
    }
}