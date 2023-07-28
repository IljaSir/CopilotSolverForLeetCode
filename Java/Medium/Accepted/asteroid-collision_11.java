class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                boolean destroyed = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() + asteroid == 0) {
                        stack.pop();
                        destroyed = true;
                        break;
                    } else if (stack.peek() + asteroid > 0) {
                        destroyed = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (!destroyed) {
                    stack.push(asteroid);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}