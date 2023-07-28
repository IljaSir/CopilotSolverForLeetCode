class Solution {
    public boolean isSelfCrossing(int[] distance) {
        
        if (distance.length < 4) return false;
        int x = 0, y = 0;
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        for (int i = 0; i < distance.length; i++) {
            int d = distance[i];
            int x0 = x, y0 = y;
            if (i % 4 == 0) {
                x += d;
                if (i > 3 && x >= x2 && x0 <= x2 && y >= y2 && y0 <= y2) return true;
            } else if (i % 4 == 1) {
                y -= d;
                if (i > 3 && y <= y2 && y0 >= y2 && x >= x2 && x0 <= x2) return true;
            } else if (i % 4 == 2) {
                x -= d;
                if (i > 3 && x <= x2 && x0 >= x2 && y <= y2 && y0 >= y2) return true;
            } else {
                y += d;
                if (i > 3 && y >= y2 && y0 <= y2 && x <= x2 && x0 >= x2) return true;
            }
            x2 = x1;
            y2 = y1;
            x1 = x0;
            y1 = y0;
        }
        return false;
    }
}