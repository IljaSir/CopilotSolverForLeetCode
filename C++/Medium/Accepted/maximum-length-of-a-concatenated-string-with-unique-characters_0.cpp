class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        vector<int> masks;
        for (string s : arr) {
            int mask = 0;
            for (char c : s) {
                int bit = c - 'a';
                if ((mask >> bit) & 1) {
                    mask = 0;
                    break;
                }
                mask |= 1 << bit;
            }
            if (mask > 0) {
                masks.push_back(mask);
            }
        }
        int ans = 0;
        function<void(int, int)> backtrack = [&](int pos, int mask) {
            if (pos == masks.size()) {
                ans = max(ans, __builtin_popcount(mask));
                return;
            }
            if ((mask & masks[pos]) == 0) {
                backtrack(pos + 1, mask | masks[pos]);
            }
            backtrack(pos + 1, mask);
        };
        backtrack(0, 0);
        return ans;
    }
};