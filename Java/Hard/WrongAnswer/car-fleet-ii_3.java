class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            int p = cars[i][0], s = cars[i][1];
            while (!stack.empty()) {
                int j = stack.peek();
                int p2 = cars[j][0], s2 = cars[j][1];
                if (s <= s2 || (ans[j] > 0 && (p2 - p) / (s - s2) >= ans[j])) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.empty()) {
                int j = stack.peek();
                ans[i] = (cars[j][0] - cars[i][0]) / (cars[i][1] - cars[j][1]);
            }
            stack.push(i);
        }
        return ans;
    }
}