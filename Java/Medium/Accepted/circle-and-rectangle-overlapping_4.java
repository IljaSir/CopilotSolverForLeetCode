class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        double x = Math.max(x1, Math.min(xCenter, x2));
        double y = Math.max(y1, Math.min(yCenter, y2));
        double distance = Math.sqrt((xCenter - x) * (xCenter - x) + (yCenter - y) * (yCenter - y));
        return distance <= radius;
    }
}