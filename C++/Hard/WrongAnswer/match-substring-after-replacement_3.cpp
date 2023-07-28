class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        unordered_map<char, char> map;
        for (auto& m : mappings) {
            map[m[0]] = m[1];
        }
        int i = 0, j = 0;
        while (i < s.size() && j < sub.size()) {
            if (s[i] == sub[j]) {
                ++i;
                ++j;
            } else {
                if (map.count(s[i]) && map[s[i]] == sub[j]) {
                    ++i;
                    ++j;
                } else {
                    ++i;
                }
            }
        }
        return j == sub.size();
    }
};