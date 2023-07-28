class Solution {
public:
    bool isReachable(int targetX, int targetY) {
        
        while (targetX > 0 && targetY > 0) {
            if (targetX < targetY) {
                targetY = targetY % targetX;
            } else {
                targetX = targetX % targetY;
            }
        }
        return targetX + targetY == 1;
    }
};