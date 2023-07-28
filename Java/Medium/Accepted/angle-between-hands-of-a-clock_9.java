class Solution {
    public double angleClock(int hour, int minutes) {
        
        double h = minutes * 0.5;
        double m = minutes * 6;
        double h1 = (hour % 12) * 30;
        double angle = Math.abs(h1 + h - m);
        if (angle > 180) {
            angle = 360 - angle;
        }
        return angle;
    }
}