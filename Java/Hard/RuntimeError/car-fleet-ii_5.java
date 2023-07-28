class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1);
        Stack<int[]> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int[] car = cars[i];
            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                double t = (double)(top[0] - car[0]) / (car[1] - top[1]);
                if (t <= 0 || t >= res[top[2]] && res[top[2]] > 0) {
                    stack.pop();
                } else {
                    res[i] = t;
                    break;
                }
            }
            stack.push(new int[]{car[0], car[1], i});
        }
        return res;
    }
}