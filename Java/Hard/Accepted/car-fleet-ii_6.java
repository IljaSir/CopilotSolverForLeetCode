class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] ans = new double[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            ans[i] = -1.0;
            int[] car = cars[i];
            while (!stack.isEmpty()) {
                int j = stack.peek();
                int[] car2 = cars[j];
                if (car[1] <= car2[1] || (ans[j] > 0 && (double) (car2[0] - car[0]) / (car[1] - car2[1]) >= ans[j])) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                int j = stack.peek();
                ans[i] = (double) (car[0] - cars[j][0]) / (cars[j][1] - car[1]);
            }
            stack.push(i);
        }
        return ans;
    }
}