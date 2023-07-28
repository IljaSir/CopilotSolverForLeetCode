class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        int i = 0;
        int cx = 0, cy = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                i = (i + 3) % 4;
            } else if (c == 'R') {
                i = (i + 1) % 4;
            } else {
                cx += x[i];
                cy += y[i];
            }
        }
        return cx == 0 && cy == 0 || i > 0;
    }
}