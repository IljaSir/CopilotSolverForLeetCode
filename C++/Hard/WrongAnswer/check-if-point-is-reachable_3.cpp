class Solution {
public:
    bool isReachable(int targetX, int targetY) {
        
        while (targetX > 0 && targetY > 0) {
            if (targetX == targetY) {
                break;
            } else if (targetX > targetY) {
                targetX %= targetY;
            } else {
                targetY %= targetX;
            }
        }
        return (targetX == 1 || targetY == 1);
    }
};