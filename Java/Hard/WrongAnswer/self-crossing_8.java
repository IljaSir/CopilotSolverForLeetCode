class Solution {
    public boolean isSelfCrossing(int[] distance) {
        
        int[] x = new int[4];
        int[] y = new int[4];
        int dx = 0;
        int dy = 1;
        int i = 0;
        for (int d : distance) {
            x[i] = x[(i + 3) % 4] + dx * d;
            y[i] = y[(i + 3) % 4] + dy * d;
            if (i >= 3 && x[i] >= x[(i + 2) % 4] && x[i - 1] <= x[(i + 1) % 4] && y[i] <= y[(i + 1) % 4] && y[i - 1] >= y[(i + 2) % 4]) {
                return true;
            }
            if (i >= 2 && x[i] == x[(i + 2) % 4] && y[i] == y[(i + 2) % 4]) {
                return true;
            }
            if (i >= 1 && x[i] == x[(i + 1) % 4] && y[i] == y[(i + 1) % 4]) {
                return true;
            }
            int tmp = dx;
            dx = dy;
            dy = -tmp;
            i = (i + 1) % 4;
        }
        return false;
    }
}