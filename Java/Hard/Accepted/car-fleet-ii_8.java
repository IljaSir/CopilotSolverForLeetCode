class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] ans = new double[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = -1.0;
            int pos = cars[i][0], speed = cars[i][1];
            while (!stack.isEmpty()) {
                int j = stack.peek();
                int pos2 = cars[j][0], speed2 = cars[j][1];
                if (speed <= speed2 || (ans[j] > 0 && (pos2 - pos) / (double) (speed - speed2) >= ans[j])) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                int j = stack.peek();
                ans[i] = (cars[j][0] - cars[i][0]) / (double) (cars[i][1] - cars[j][1]);
            }
            stack.push(i);
        }
        return ans;
    }
}