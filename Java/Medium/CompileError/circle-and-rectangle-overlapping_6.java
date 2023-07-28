class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        // check if the circle is inside the rectangle
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
            return true;
        }
        // check if the rectangle is inside the circle
        if (x1 >= xCenter - radius && x2 <= xCenter + radius && y1 >= yCenter - radius && y2 <= yCenter + radius) {
            return true;
        }
        // check if the rectangle overlaps with the circle on the left
        if (x1 <= xCenter - radius && x2 >= xCenter - radius && yCenter >= y1 && yCenter <= y2) {
            return true;
        }
        // check if the rectangle overlaps with the circle on the right
        if (x1 <= xCenter + radius && x2 >= xCenter + radius && yCenter >= y1 && yCenter <= y2) {
            return true;
        }
        // check if the rectangle overlaps with the circle on the top
        if (y1 <= yCenter + radius && y2 >= yCenter + radius && xCenter >= x1 && xCenter <= x2) {
            return true;
        }
        // check if the rectangle overlaps with the circle on the bottom
        if (y1 <= yCenter - radius && y2 >= yCenter - radius && xCenter >= x1 && xCenter <= x2) {
            return true;
        }
        // check if the circle overlaps with the rectangle on the top-left corner
        if (x1 <= xCenter - radius && y1 <= yCenter + radius) {
            double distance = Math.sqrt(Math.pow(x1 - xCenter, 2) + Math.pow(y1 - yCenter, 2));
            if (distance <= radius) {
                return true;
            }
        }
        // check if the circle overlaps with the rectangle on the top-right corner
        if (x2 >= xCenter + radius && y1 <= yCenter + radius) {
            double distance = Math.sqrt(Math.pow(x2 - xCenter, 2) + Math.pow(y1 - yCenter, 2));
            if (distance <= radius) {
                return true;
            }
        }
        // check if the circle overlaps with the rectangle on the bottom-left corner
        if (x1 <= xCenter - radius && y2 >= y
    }
}