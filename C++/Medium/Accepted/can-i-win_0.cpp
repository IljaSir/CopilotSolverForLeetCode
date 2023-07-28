class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        unordered_map<int, bool> cache;
        return helper(maxChoosableInteger, desiredTotal, 0, cache);
    }
    bool helper(int maxChoosableInteger, int desiredTotal, int used, unordered_map<int, bool>& cache) {
        if (cache.count(used)) return cache[used];
        for (int i = 1; i <= maxChoosableInteger; ++i) {
            int cur = 1 << (i - 1);
            if ((cur & used) == 0) {
                if (desiredTotal <= i || !helper(maxChoosableInteger, desiredTotal - i, cur | used, cache)) {
                    cache[used] = true;
                    return true;
                }
            }
        }
        cache[used] = false;
        return false;
    }
};