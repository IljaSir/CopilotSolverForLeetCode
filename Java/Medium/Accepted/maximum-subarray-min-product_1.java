class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, nums[i] * (preSum[right[i]] - preSum[left[i] + 1]));
        }
        return (int) (ans % 1000000007);
    }
}