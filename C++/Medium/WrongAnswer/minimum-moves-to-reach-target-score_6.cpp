class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        int move = 0;
        while (target > 1) {
            if (target % 2 == 0) {
                target /= 2;
                move++;
                maxDoubles--;
            } else {
                target = (target + 1) / 2;
                move += 2;
                maxDoubles--;
            }
        }
        return move;
    }
};