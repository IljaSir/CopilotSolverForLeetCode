class Solution {
public:
    bool checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        // x1 <= x2, y1 <= y2
        int x = xCenter, y = yCenter;
        if (x < x1) {
            x = x1;
        } else if (x > x2) {
            x = x2;
        }
        if (y < y1) {
            y = y1;
        } else if (y > y2) {
            y = y2;
        }
        return (xCenter - x) * (xCenter - x) + (yCenter - y) * (yCenter - y) <= radius * radius;
    }
};