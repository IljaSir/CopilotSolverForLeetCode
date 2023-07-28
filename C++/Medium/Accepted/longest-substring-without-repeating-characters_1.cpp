class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.size();
        int ans = 0;
        map<char, int> mp;
        for (int i = 0, j = 0; j < n; j++) {
            if (mp.find(s[j]) != mp.end()) {
                i = max(mp[s[j]], i);
            }
            ans = max(ans, j - i + 1);
            mp[s[j]] = j + 1;
        }
        return ans;
    }
};