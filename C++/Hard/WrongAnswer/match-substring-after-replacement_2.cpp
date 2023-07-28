class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        unordered_map<char, char> mp;
        for (auto& v : mappings) {
            mp[v[0]] = v[1];
        }
        int i = 0, j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s[i] == sub[j]) {
                ++i;
                ++j;
            } else if (mp.count(s[i])) {
                s[i] = mp[s[i]];
            } else {
                return false;
            }
        }
        return j == sub.length();
    }
};