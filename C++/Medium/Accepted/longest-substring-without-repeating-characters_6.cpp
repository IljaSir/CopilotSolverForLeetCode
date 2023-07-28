class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.size();
        int res = 0;
        int i = 0, j = 0;
        unordered_map<char, int> map;
        while (j < n) {
            if (map.count(s[j]) > 0) {
                i = max(i, map[s[j]] + 1);
            }
            map[s[j]] = j;
            res = max(res, j - i + 1);
            j++;
        }
        return res;
    }
};