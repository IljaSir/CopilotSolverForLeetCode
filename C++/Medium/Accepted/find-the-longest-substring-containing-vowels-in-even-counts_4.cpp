class Solution {
public:
    int findTheLongestSubstring(string s) {
        
        unordered_map<char, int> mp = {{'a', 1}, {'e', 2}, {'i', 4}, {'o', 8}, {'u', 16}};
        unordered_map<int, int> m;
        int n = s.size(), res = 0, state = 0;
        m[0] = -1;
        for (int i = 0; i < n; ++i) {
            if (mp.count(s[i])) {
                state ^= mp[s[i]];
            }
            if (m.count(state)) {
                res = max(res, i - m[state]);
            } else {
                m[state] = i;
            }
        }
        return res;
    }
};