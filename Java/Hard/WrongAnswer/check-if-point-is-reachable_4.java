class Solution {
    public boolean isReachable(int targetX, int targetY) {
        
        while (targetX > 0 && targetY > 0) {
            if (targetX == 1 && targetY == 1) {
                return true;
            }
            if (targetX > targetY) {
                targetX %= targetY;
            } else {
                targetY %= targetX;
            }
        }
        return false;
    }
}