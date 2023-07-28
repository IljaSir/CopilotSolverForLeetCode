class Solution {
public:
    double angleClock(int hour, int minutes) {
        
        double hourAngle = (hour % 12 + minutes / 60.0) / 12 * 360;
        double minuteAngle = minutes / 60.0 * 360;
        double angle = abs(hourAngle - minuteAngle);
        return min(angle, 360 - angle);
    }
};