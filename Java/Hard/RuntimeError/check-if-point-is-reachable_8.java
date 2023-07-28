class Solution {
    public boolean isReachable(int targetX, int targetY) {
        
        if(targetX < targetY){
            int temp = targetX;
            targetX = targetY;
            targetY = temp;
        }
        if(targetX == 1 && targetY == 1){
            return true;
        }
        if(targetX < targetY){
            return false;
        }
        if(targetX % 2 == 0){
            return isReachable(targetX / 2, targetY);
        }
        return isReachable(targetX - targetY, targetY);
    }
}