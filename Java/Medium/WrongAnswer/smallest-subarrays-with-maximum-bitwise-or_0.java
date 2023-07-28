class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && (nums[i] | nums[stk.peek()]) == nums[stk.peek()]) {
                stk.pop();
            }
            ans[i] = stk.isEmpty() ? n - i : stk.peek() - i;
            stk.push(i);
        }
        return ans;
    }
}