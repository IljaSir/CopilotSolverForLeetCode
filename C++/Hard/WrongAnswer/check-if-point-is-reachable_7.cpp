class Solution {
public:
    bool isReachable(int targetX, int targetY) {
        
        if (targetX < targetY) {
            swap(targetX, targetY);
        }
        if (targetX < 1 || targetY < 1) {
            return false;
        }
        if (targetX == 1 && targetY == 1) {
            return true;
        }
        if (targetX == targetY) {
            return false;
        }
        return isReachable(targetX - targetY, targetY);
    }
};