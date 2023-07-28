class Solution {
public:
    int balancedString(string s) {
        
        int n = s.size();
        int m = n / 4;
        unordered_map<char, int> mp;
        for (char c : s) {
            mp[c]++;
        }
        int i = 0, j = 0;
        int ans = n;
        while (j < n) {
            while (j < n && (mp['Q'] > m || mp['W'] > m || mp['E'] > m || mp['R'] > m)) {
                mp[s[j]]--;
                j++;
            }
            while (i < n && mp['Q'] <= m && mp['W'] <= m && mp['E'] <= m && mp['R'] <= m) {
                ans = min(ans, j - i);
                mp[s[i]]++;
                i++;
            }
        }
        return ans;
    }
};