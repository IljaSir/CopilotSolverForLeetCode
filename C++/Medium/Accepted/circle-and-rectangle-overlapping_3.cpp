class Solution {
public:
    bool checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        int x = xCenter, y = yCenter;
        if (x < x1) x = x1;
        if (x > x2) x = x2;
        if (y < y1) y = y1;
        if (y > y2) y = y2;
        return (x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) <= radius * radius;
    }
};