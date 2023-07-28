class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 1;
        for (int i = 0; i < k; i++) {
            ans = ans * nums[i] % 1000000007;
        }
        if (nums[0] >= 0) {
            return (int) ans;
        }
        long ans2 = 1;
        int i = 0, j = n - 1;
        while (i < k) {
            ans2 = ans2 * nums[j] % 1000000007;
            i++;
            j--;
        }
        return (int) Math.max(ans, ans2);
    }
}