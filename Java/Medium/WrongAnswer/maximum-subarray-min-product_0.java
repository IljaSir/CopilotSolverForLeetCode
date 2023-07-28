class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i] + 1, r = right[i] - 1;
            res = Math.max(res, (long) nums[i] * (preSum[r + 1] - preSum[l]));
        }
        return (int) (res % 1000000007);
    }
}