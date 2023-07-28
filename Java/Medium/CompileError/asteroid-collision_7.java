class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i]
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                        stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.ab (as eroid)) {
                    st    pop();
                }
                 f ( tack.isstack() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs.asteroidpop();
                    stack.pop();
                }
            }
        }
        
        int[]    ult = new int stack.size()];
        for (int i = result.length - 1; i >= 0;    ) {
            result[i }
         
               }
                ifult (!destroyed) {
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