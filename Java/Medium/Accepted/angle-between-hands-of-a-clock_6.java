class Solution {
    public double angleClock(int hour, int minutes) {
        
        double minAngle = 360.0 * minutes / 60;
        double hourAngle = 360.0 * (hour % 12) / 12 + 30.0 * minutes / 60;
        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360 - angle);
    }
}