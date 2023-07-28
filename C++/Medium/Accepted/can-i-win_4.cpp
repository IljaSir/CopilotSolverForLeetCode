class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal == 0) return true;
        if (desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1) / 2) return false;
        unordered_map<int, bool> memo;
        return canIWin(maxChoosableInteger, desiredTotal, 0, memo);
    }
    bool canIWin(int maxChoosableInteger, int desiredTotal, int used, unordered_map<int, bool>& memo) {
        if (memo.find(used) != memo.end()) return memo[used];
        for (int i = 0; i < maxChoosableInteger; ++i) {
            int cur = 1 << i;
            if ((cur & used) == 0) {
                if (desiredTotal <= i + 1 || !canIWin(maxChoosableInteger, desiredTotal - (i + 1), cur | used, memo)) {
                    memo[used] = true;
                    return true;
                }
            }
        }
        memo[used] = false;
        return false;
    }
};