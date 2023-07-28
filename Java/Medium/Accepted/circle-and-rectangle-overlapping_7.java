class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        // 1. If the center of the circle is in the rectangle, return true.
        // 2. If the center of the circle is not in the rectangle, but the distance from the center of the circle to the nearest point in the rectangle is less than or equal to the radius of the circle, return true.
        // 3. Otherwise, return false.
        int x = xCenter;
        int y = yCenter;
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
            return true;
        }
        if (xCenter < x1) {
            x = x1;
        }
        if (xCenter > x2) {
            x = x2;
        }
        if (yCenter < y1) {
            y = y1;
        }
        if (yCenter > y2) {
            y = y2;
        }
        int distance = (int) Math.sqrt(Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2));
        if (distance <= radius) {
            return true;
        }
        return false;
    }
}