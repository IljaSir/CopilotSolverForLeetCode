class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] res = new int[s.length()];
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int x = startPos[0], y = startPos[1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int dir = c == 'R' ? 0 : c == 'D' ? 1 : c == 'L' ? 2 : 3;
            int nx = x + dirX[dir];
            int ny = y + dirY[dir];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                x = nx;
                y = ny;
            }
            res[i] = x * n + y;
        }
        int[] min = new int[n * n];
        Arrays.fill(min, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (min[res[i]] == -1) {
                min[res[i]] = i;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            res[i] = min[res[i]] - i;
        }
        return res;
    }
}