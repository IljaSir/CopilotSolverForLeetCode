class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1.0);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (res[stack.peek()] < 0 || (double) (cars[stack.peek()][1] - cars[i][1]) / (cars[i][0] - cars[stack.peek()][0]) >= res[stack.peek()])) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = (double) (cars[stack.peek()][0] - cars[i][0]) / (cars[i][1] - cars[stack.peek()][1]);
            }
            stack.push(i);
        }
        return res;
    }
}