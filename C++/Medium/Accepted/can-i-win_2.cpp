class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) return true;
        if (desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1) / 2) return false;
        unordered_map<int, bool> mp;
        return helper(mp, maxChoosableInteger, desiredTotal, 0);
    }
    
    bool helper(unordered_map<int, bool> &mp, int M, int D, int state) {
        if (mp.find(state) != mp.end()) return mp[state];
        for (int i = 0; i < M; i++) {
            int cur = 1 << i;
            if ((state & cur) == 0) {
                if (D <= i + 1 || !helper(mp, M, D - (i + 1), state | cur)) {
                    mp[state] = true;
                    return true;
                }
            }
        }
        mp[state] = false;
        return false;
    }
};