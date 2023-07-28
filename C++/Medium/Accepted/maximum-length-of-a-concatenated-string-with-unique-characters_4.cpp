class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        vector<int> mask;
        for (auto& s : arr) {
            int m = 0;
            for (auto c : s) {
                int bit = 1 << (c - 'a');
                if (m & bit) { // Duplicate char
                    m = 0;
                    break;
                }
                m |= bit;
            }
            if (m > 0) mask.push_back(m);
        }
        int ans = 0;
        function<void(int, int)> backtrack = [&](int pos, int m) {
            if (pos == mask.size()) {
                ans = max(ans, __builtin_popcount(m));
                return;
            }
            if ((m & mask[pos]) == 0) backtrack(pos + 1, m | mask[pos]);
            backtrack(pos + 1, m);
        };
        backtrack(0, 0);
        return ans;
    }
};