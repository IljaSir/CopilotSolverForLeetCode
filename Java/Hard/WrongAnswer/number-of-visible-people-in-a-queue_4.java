class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                result[i]++;
                result[stack.pop()]++;
            }
            if (!stack.isEmpty()) {
                result[i]++;
            }
            stack.push(i);
        }
        return result;
    }
}