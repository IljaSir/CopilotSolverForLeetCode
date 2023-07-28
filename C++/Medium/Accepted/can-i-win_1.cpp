class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        unordered_map<int, bool> cache;
        return dfs(maxChoosableInteger, desiredTotal, 0, cache);
    }
    bool dfs(int maxChoosableInteger, int desiredTotal, int state, unordered_map<int, bool>& cache) {
        if (cache.count(state)) return cache[state];
        for (int i = 0; i < maxChoosableInteger; ++i) {
            int cur = 1 << i;
            if ((state & cur) == 0) {
                if (desiredTotal <= i + 1 || !dfs(maxChoosableInteger, desiredTotal - (i + 1), state | cur, cache)) {
                    cache[state] = true;
                    return true;
                }
            }
        }
        cache[state] = false;
        return false;
    }
};