class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        int n = words.size();
        vector<int> mp(26, 0);
        for (int i = 0; i < n; i++) {
            mp[words[i][0] - 'a'] |= (1 << i);
            mp[words[i][1] - 'a'] |= (1 << i);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i; j < 26; j++) {
                int mask = mp[i] | mp[j];
                int cnt = __builtin_popcount(mask);
                if (cnt > 1 && (mask & (mask - 1)) == 0) {
                    ans = max(ans, cnt * 2);
                }
            }
        }
        return ans;
    }
};