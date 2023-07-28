class Solution {
    public boolean isReachable(int targetX, int targetY) {
        
        while (targetX > 0 && targetY > 0) {
            if (targetX < targetY) {
                targetY %= targetX;
            } else {
                targetX %= targetY;
            }
        }
        return (targetX + targetY) == 1;
    }
}