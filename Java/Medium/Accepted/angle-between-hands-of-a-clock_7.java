class Solution {
    public double angleClock(int hour, int minutes) {
        
        if(hour == 12) hour = 0;
        double angle = Math.abs(5.5 * minutes - 30 * hour);
        if(angle > 180) angle = 360 - angle;
        return angle;
    }
}