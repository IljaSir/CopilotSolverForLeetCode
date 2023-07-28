class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1.0);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            int p = cars[i][0], s = cars[i][1];
            while (!stack.isEmpty()) {
                int j = stack.peek(), p2 = cars[j][0], s2 = cars[j][1];
                if (s <= s2 || (res[j] > 0 && (p2 - p) / (s - s2) >= res[j])) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                int j = stack.peek();
                res[i] = (cars[j][0] - p) / (s - cars[j][1]);
            }
            stack.push(i);
        }
        return res;
    }
}