class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) return true;
        if (desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1) / 2) return false;
        vector<bool> used(maxChoosableInteger + 1, false);
        return helper(used, desiredTotal);
    }
};