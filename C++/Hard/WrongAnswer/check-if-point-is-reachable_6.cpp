class Solution {
public:
    bool isReachable(int targetX, int targetY) {
        
        while (targetX && targetY) {
            if (targetX < targetY) {
                swap(targetX, targetY);
            }
            if (targetY == 1) {
                return (targetX - 1) % 2 == 0;
            }
            targetX %= targetY;
        }
        return targetX + targetY == 1;
    }
};