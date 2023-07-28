class Solution {
    public double angleClock(int hour, int minutes) {
        
        double angle = 0;
        double h = hour * 30;
        double m = minutes * 6;
        if (hour == 12) {
            h = 0;
        }
        h += (double)minutes / 2;
        angle = Math.abs(h - m);
        if (angle > 180) {
            angle = 360 - angle;
        }
        return angle;
    }
}