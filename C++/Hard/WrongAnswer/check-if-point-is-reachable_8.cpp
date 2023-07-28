class Solution {
public:
    bool isReachable(int targetX, int targetY) {
        
        if (targetX == targetY) return targetX == 1;
        if (targetX < targetY) return isReachable(targetY, targetX);
        if (targetX % targetY == 0) return targetX / targetY % 2 == 1;
        return isReachable(targetX - targetY, targetY);
    }
};