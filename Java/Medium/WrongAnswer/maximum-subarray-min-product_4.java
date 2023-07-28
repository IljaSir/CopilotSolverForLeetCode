class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int[] stack = new int[n];
        int top = 0;
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            while (top > 0 && (i == n || nums[stack[top-1]] > nums[i])) {
                int j = stack[--top];
                int left = top == 0 ? 0 : stack[top-1] + 1;
                ans = Math.max(ans, (long) nums[j] * (sum[i] - sum[left]));
            }
            stack[top++] = i;
        }
        return (int) (ans % 1000000007);
    }
}