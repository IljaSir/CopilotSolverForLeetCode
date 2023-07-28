class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1.0);
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int pos = cars[i][0], speed = cars[i][1];
            while (!st.isEmpty()) {
                int j = st.peek();
                int pos2 = cars[j][0], speed2 = cars[j][1];
                if (speed <= speed2 || (res[j] > 0 && (pos2 - pos) / (double) (speed - speed2) >= res[j])) {
                    st.pop();
                } else {
                    break;
                }
            }
            if (!st.isEmpty()) {
                int j = st.peek();
                int pos2 = cars[j][0], speed2 = cars[j][1];
                res[i] = (pos2 - pos) / (double) (speed - speed2);
            }
            st.push(i);
        }
        return res;
    }
}