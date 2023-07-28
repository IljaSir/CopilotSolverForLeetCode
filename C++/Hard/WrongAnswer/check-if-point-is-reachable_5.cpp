class Solution {
public:
    bool isReachable(int targetX, int targetY) {
        
        if(targetX == 1 && targetY == 1) return true;
        if(targetX < 1 || targetY < 1) return false;
        if(targetX > targetY) return isReachable(targetX - targetY, targetY);
        if(targetX < targetY) return isReachable(targetX, targetY - targetX);
        return false;
    }
};