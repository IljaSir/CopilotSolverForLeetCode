class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int res = 0;
        unordered_map<char, int> map;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.find(s[j]) != map.end()) {
                i = max(map[s[j]], i);
            }
            res = max(res, j - i + 1);
            map[s[j]] = j + 1;
        }
        return res;
    }
};