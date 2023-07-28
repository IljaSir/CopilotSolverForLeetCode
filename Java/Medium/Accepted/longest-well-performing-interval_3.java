class Solution {
    public int longestWPI(int[] hours) {
        
        int[] score = new int[hours.length + 1];
        for (int i = 1; i <= hours.length; i++) {
            score[i] = score[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        }
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < score.length; i++) {
            if (stack.isEmpty() || score[i] < score[stack.peek()]) {
                stack.push(i);
            }
        }
        for (int i = score.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && score[i] > score[stack.peek()]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }
}