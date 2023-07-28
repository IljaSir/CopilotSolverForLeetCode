class Solution {
    public double angleClock(int hour, int minutes) {
        
        double hourAngle = (hour * 30) + (minutes * 0.5);
        double minuteAngle = minutes * 6;
        double angle = Math.abs(hourAngle - minuteAngle);
        if (angle > 180) {
            angle = 360 - angle;
        }
        return angle;
    }
}