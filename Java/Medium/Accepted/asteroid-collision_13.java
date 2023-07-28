class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int len = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int cur = asteroids[i];
            if (cur > 0) {
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -cur) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(cur);
                } else if (stack.peek() == -cur) {
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}