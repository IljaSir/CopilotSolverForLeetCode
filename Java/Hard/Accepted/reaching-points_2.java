class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }
        if (tx > ty) {
            return reachingPoints(sx, sy, tx % ty, ty);
        } else {
            return reachingPoints(sx, sy, tx, ty % tx);
        }
    }
}