class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long res = 0;
        int n = nums.length;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        Arrays.fill(nextLess, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                nextLess[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                prevLess[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            long sum = 0;
            int j = i;
            while (j < n) {
                sum += nums[j];
                if (sum * (nextLess[j] - i) >= k) {
                    break;
                }
                j = nextLess[j];
            }
            res += j - i;
        }
        return res;
    }
}