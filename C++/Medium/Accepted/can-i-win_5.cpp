class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal == 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        unordered_map<int, bool> cache;
        return canIWin(maxChoosableInteger, desiredTotal, 0, cache);
    }
    
    bool canIWin(int maxChoosableInteger, int desiredTotal, int used, unordered_map<int, bool>& cache) {
        if (cache.count(used)) return cache[used];
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            if ((used & mask) == 0) {
                if (desiredTotal <= i || !canIWin(maxChoosableInteger, desiredTotal - i, used | mask, cache)) {
                    cache[used] = true;
                    return true;
                }
            }
        }
        cache[used] = false;
        return false;
    }
};