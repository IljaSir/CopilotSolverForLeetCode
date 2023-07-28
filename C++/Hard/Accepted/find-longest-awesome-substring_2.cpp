class Solution {
public:
    int longestAwesome(string s) {
        
        vector<int> pos(1024, s.size());
        pos[0] = -1;
        int mask = 0;
        int res = 0;
        for (int i = 0; i < s.size(); ++i) {
            mask ^= 1 << (s[i] - '0');
            res = max(res, i - pos[mask]);
            for (int j = 0; j < 10; ++j) {
                int t = mask ^ (1 << j);
                res = max(res, i - pos[t]);
            }
            pos[mask] = min(pos[mask], i);
        }
        return res;
    }
};