class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.size();
        int ans = 0;
        int i = 0, j = 0;
        unordered_set<char> set;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (set.find(s[j]) == set.end()) {
                set.insert(s[j++]);
                ans = max(ans, j - i);
            } else {
                set.erase(s[i++]);
            }
        }
        return ans;
    }
};