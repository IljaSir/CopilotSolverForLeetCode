class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        long res = 0;
        int n = robot.size();
        int m = factory.length;
        int[][] r = new int[n][2];
        int[][] f = new int[m][2];
        for (int i = 0; i < n; i++) {
            r[i][0] = robot.get(i);
            r[i][1] = i;
        }
        for (int i = 0; i < m; i++) {
            f[i][0] = factory[i][0];
            f[i][1] = factory[i][1];
        }
        Arrays.sort(r, (a, b) -> a[0] - b[0]);
        Arrays.sort(f, (a, b) -> a[0] - b[0]);
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (r[i][0] <= f[j][0]) {
                f[j][1]--;
                res += f[j][0] - r[i][0];
                i++;
            } else {
                j++;
            }
        }
        i = n - 1;
        j = m - 1;
        while (i >= 0 && j >= 0) {
            if (r[i][0] >= f[j][0]) {
                f[j][1]--;
                res += r[i][0] - f[j][0];
                i--;
            } else {
                j--;
            }
        }
        return res;
    }
}