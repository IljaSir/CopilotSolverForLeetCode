class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
            return true;
        }
        if (xCenter < x1 && yCenter < y1) {
            return distance(xCenter, yCenter, x1, y1) <= radius;
        }
        if (xCenter < x1 && yCenter > y2) {
            return distance(xCenter, yCenter, x1, y2) <= radius;
        }
        if (xCenter > x2 && yCenter < y1) {
            return distance(xCenter, yCenter, x2, y1) <= radius;
        }
        if (xCenter > x2 && yCenter > y2) {
            return distance(xCenter, yCenter, x2, y2) <= radius;
        }
        if (xCenter < x1) {
            return x1 - xCenter <= radius;
        }
        if (xCenter > x2) {
            return xCenter - x2 <= radius;
        }
        if (yCenter < y1) {
            return y1 - yCenter <= radius;
        }
        if (yCenter > y2) {
            return yCenter - y2 <= radius;
        }
        return false;
    }
}