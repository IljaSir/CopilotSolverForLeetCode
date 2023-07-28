class Solution {
    public double angleClock(int hour, int minutes) {
        
        double angleHour = 30 * (hour % 12) + 0.5 * minutes;
        double angleMinutes = 6 * minutes;
        double angle = Math.abs(angleHour - angleMinutes);
        return Math.min(angle, 360 - angle);
    }
}