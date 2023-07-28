class Solution {
public:
    bool checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        int x = xCenter, y = yCenter;
        if (xCenter < x1) x = x1;
        else if (xCenter > x2) x = x2;
        if (yCenter < y1) y = y1;
        else if (yCenter > y2) y = y2;
        return (x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) <= radius * radius;
    }
};