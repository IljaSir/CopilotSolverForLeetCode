class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        // 1. find the prefix sum
        // 2. find the max min product
        // 3. find the max sum
        int n = nums.length;
        long[] prefixSum = new long[n];
        long maxSum = 0;
        long maxMinProduct = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i] = nums[i] + (i == 0 ? 0 : prefixSum[i - 1]);
            maxSum = Math.max(maxSum, prefixSum[i]);
        }
        
        // find the max min product
        // 1. find the previous smaller element
        // 2. find the next smaller element
        // 3. calculate the min product
        Stack<Integer> stack = new Stack<>();
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            maxMinProduct = Math.max(maxMinProduct, nums[i] * (prefixSum[nextSmaller[i] - 1] - (prevSmaller[i] == -1 ? 0 : prefixSum[prevSmaller[i]])));
        }
        
        return (int) (maxMinProduct % (long) (1e9 + 7));
    }
}