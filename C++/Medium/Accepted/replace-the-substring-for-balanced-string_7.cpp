class Solution {
public:
    int balancedString(string s) {
        
        int n = s.size();
        int target = n / 4;
        int ans = n;
        unordered_map<char, int> mp;
        for (char c : s) {
            mp[c]++;
        }
        int i = 0;
        for (int j = 0; j < n; j++) {
            mp[s[j]]--;
            while (i < n && mp['Q'] <= target && mp['W'] <= target && mp['E'] <= target && mp['R'] <= target) {
                ans = min(ans, j - i + 1);
                mp[s[i]]++;
                i++;
            }
        }
        return ans;
    }
};