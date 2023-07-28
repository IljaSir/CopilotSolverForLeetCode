class Solution {
    public boolean isReachable(int targetX, int targetY) {
        
        while(targetX > 0 && targetY > 0) {
            if(targetX < targetY) {
                targetY = targetY % targetX;
            } else {
                targetX = targetX % targetY;
            }
        }
        return targetX == 1 || targetY == 1;
    }
}
    }
}