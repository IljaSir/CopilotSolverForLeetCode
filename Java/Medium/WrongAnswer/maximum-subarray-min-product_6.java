class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; ++i) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        long res = 0;
        for (int i = 0; i <= n; ++i) {
            while (stack.peek() != -1 && (i == n || nums[i] < nums[stack.peek()])) {
                int j = stack.pop();
                res = Math.max(res, (long)nums[j] * (prefix[i] - prefix[stack.peek()+1]));
            }
            stack.push(i);
        }
        return (int)(res % 1000000007);
    }
}