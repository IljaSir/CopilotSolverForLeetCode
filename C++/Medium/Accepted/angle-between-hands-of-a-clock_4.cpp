class Solution {
public:
    double angleClock(int hour, int minutes) {
        
        double h = hour % 12 + minutes / 60.0;
        double m = minutes;
        double angle = abs(h * 30 - m * 6);
        return min(angle, 360 - angle);
    }
};