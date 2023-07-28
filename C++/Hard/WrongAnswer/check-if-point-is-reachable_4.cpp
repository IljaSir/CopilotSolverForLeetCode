class Solution {
public:
    bool isReachable(int targetX, int targetY) {
        
        while (targetX > 0 && targetY > 0) {
            if (targetX == targetY) {
                return targetX == 1;
            }
            if (targetX > targetY) {
                targetX %= targetY;
            } else {
                targetY %= targetX;
            }
        }
        return false;
    }
};