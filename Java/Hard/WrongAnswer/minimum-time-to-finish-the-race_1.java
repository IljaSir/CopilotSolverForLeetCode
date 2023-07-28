class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = tires[i][0];
        }
        Arrays.sort(t);
        int l = 0, r = (int) 1e9;
        while (l < r) {
            int m = (l + r) >> 1;
            if (check(m, t, changeTime, numLaps)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean check(int time, int[] t, int changeTime, int numLaps) {
        int n = t.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = time / t[i];
            if (x == 0) {
                continue;
            }
            int res = (int) (1L * t[i] * (x - 1) * (x - 2) / 2 + 1L * t[i] * (x - 1) * (numLaps - x) + 1L * t[i] * (numLaps - x) * (numLaps - x - 1) / 2);
            if (res <= time - changeTime * (x - 1)) {
                max = Math.max(max, x);
            }
        }
        return max >= numLaps;
    }
}