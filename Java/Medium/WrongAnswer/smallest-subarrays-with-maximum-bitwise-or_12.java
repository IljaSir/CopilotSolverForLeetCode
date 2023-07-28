class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int[] next = new int[n];
        Arrays.fill(next, n);
        for (int i = 0; i < n; i++) {
            int or = nums[i];
            for (int j = i + 1; j < n && j - i <= 31; j++) {
                or |= nums[j];
                if (or == (1 << j - i + 1) - 1)
                    next[i] = j;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && next[stack.peek()] >= next[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}