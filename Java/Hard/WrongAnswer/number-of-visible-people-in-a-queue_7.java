class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.size();
            stack.push(i);
        }
        return res;
    }
}