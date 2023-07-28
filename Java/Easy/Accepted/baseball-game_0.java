class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            if ("+".equals(op)) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for (int score : stack) {
            ans += score;
        }
        return ans;
    }
}