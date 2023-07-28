class Solution {
public:
    double angleClock(int hour, int minutes) {
        
        double h = 30 * hour + 0.5 * minutes;
        double m = 6 * minutes;
        double angle = abs(h - m);
        if (angle > 180) {
            angle = 360 - angle;
        }
        return angle;
    }
};