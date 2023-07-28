class Solution {
    public boolean isReachable(int targetX, int targetY) {
        
        while (targetX > 1 || targetY > 1) {
            if (targetX > targetY) {
                targetX = targetX % targetY;
            } else {
                targetY = targetY % targetX;
            }
        }
        return targetX == 1 || targetY == 1;
    }
}