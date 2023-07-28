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
                    } else {;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}