class Solution {
    public double angleClock(int hour, int minutes) {
        
        double h = (hour % 12) * 30.0 + minutes * 0.5;
        double m = minutes * 6.0;
        double diff = Math.abs(h - m);
        return Math.min(diff, 360 - diff);
    }
}