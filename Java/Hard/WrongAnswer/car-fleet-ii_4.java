class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            int p = cars[i][0], s = cars[i][1];
            while (!stack.isEmpty()) {
                int j = stack.peek(), pj = cars[j][0], sj = cars[j][1];
                if (s <= sj || (res[j] > 0 && (pj - p) / (s - sj) >= res[j])) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                int j = stack.peek(), pj = cars[j][0], sj = cars[j][1];
                res[i] = (pj - p) / (s - sj);
            }
            stack.push(i);
        }
        return res;
    }
}