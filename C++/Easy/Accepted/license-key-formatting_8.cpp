class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        
        int len = s.length();
        int cnt = 0;
        string ans = "";
        for (int i = len - 1; i >= 0; i--) {
            if (s[i] == '-') {
                continue;
            }
            if (cnt == k) {
                ans += '-';
                cnt = 0;
            }
            ans += toupper(s[i]);
            cnt++;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};