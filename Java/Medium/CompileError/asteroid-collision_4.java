class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0) {
                stack.push(asteroids[i]);
            } else if (stack.peek() <= -asteroids[i]) {
                if (stack.pop() < -asteroids[i]) {
                    i--;
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;


        Stack<Integer> stack = new Stack<>();
    }
}