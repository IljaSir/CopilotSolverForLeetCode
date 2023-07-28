class Solution {
    public double angleClock(int hour, int minutes) {
        
        double h = hour * 30 + minutes * 0.5;
        double m = minutes * 6;
        double a = Math.abs(h - m);
        return Math.min(a, 360 - a);
    }
}