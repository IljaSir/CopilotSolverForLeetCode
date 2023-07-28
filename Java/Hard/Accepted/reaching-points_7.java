class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        if (tx < sx || ty < sy) return false;
        if (tx == sx && ty == sy) return true;
        if (tx == ty) return false;
        if (tx > ty) {
            if (ty > sy) {
                return reachingPoints(sx, sy, tx % ty, ty);
            } else {
                return (tx - sx) % ty == 0;
            }
        } else {
            if (tx > sx) {
                return reachingPoints(sx, sy, tx, ty % tx);
            } else {
                return (ty - sy) % tx == 0;
            }
        }
    }
}