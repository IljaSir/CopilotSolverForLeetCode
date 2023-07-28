class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                result[i]++;
                result[stack.pop()]++;
            }
            stack.push(i);
        }
        return result;
    }
}