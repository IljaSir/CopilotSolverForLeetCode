class Solution {
public:
    bool checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        int x = max(x1, min(xCenter, x2));
        int y = max(y1, min(yCenter, y2));
        int distance = (x - xCenter)*(x - xCenter) + (y - yCenter)*(y - yCenter);
        return distance <= radius*radius;
    }
};