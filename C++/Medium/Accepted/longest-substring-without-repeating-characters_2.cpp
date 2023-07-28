class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char, int> m;
        int res = 0;
        for (int i = 0, j = 0; j < s.size(); j++) {
            if (m.count(s[j])) {
                i = max(m[s[j]], i);
            }
            res = max(res, j - i + 1);
            m[s[j]] = j + 1;
        }
        return res;
    }
};