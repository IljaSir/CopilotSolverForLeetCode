class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] res = new int[s.length()];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int x = startPos[0], y = startPos[1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                res[i] = Math.min(n - 1 - y, res[i]);
                y += res[i];
            } else if (c == 'L') {
                res[i] = Math.min(y, res[i]);
                y -= res[i];
            } else if (c == 'U') {
                res[i] = Math.min(x, res[i]);
                x -= res[i];
            } else {
                res[i] = Math.min(n - 1 - x, res[i]);
                x += res[i];
            }
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            res[i] += res[i + 1];
        }
        return res;
    }
}