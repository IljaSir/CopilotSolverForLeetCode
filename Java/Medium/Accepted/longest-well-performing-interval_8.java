class Solution {
    public int longestWPI(int[] hours) {
        
        int[] hoursCopy = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            hoursCopy[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] prefixSum = new int[hours.length + 1];
        for (int i = 0; i < hours.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + hoursCopy[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (stack.isEmpty() || prefixSum[stack.peek()] > prefixSum[i]) {
                stack.push(i);
            }
        }
        int result = 0;
        for (int i = prefixSum.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prefixSum[stack.peek()] < prefixSum[i]) {
                result = Math.max(result, i - stack.pop());
            }
        }
        return result;
    }
}