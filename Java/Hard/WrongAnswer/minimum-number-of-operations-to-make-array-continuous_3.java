class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int ans = n;
        int i = 0;
        for (int j = 0; j < n; j++) {
            while (nums[j] - nums[i] >= n) {
                i++;
            }
            ans = Math.min(ans, n - (j - i + 1));
        }
        return ans;
    }
}