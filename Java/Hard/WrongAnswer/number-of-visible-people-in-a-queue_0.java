class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                res[i]++;
                res[stack.pop()]++;
            }
            if (!stack.isEmpty()) res[i]++;
            stack.push(i);
        }
        return res;
    }
}