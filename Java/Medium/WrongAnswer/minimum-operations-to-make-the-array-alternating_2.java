class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        odd[0] = nums[0] - 1;
        even[0] = 0;
        for (int i = 1; i < n; i++) {
            odd[i] = Math.min(even[i - 1], odd[i - 1]) + nums[i] - 1;
            even[i] = Math.min(even[i - 1], odd[i - 1]) + 1 - nums[i];
        }
        return Math.min(odd[n - 1], even[n - 1]);
    }
}