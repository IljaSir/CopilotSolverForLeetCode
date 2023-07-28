class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        
        int n = s.length();
        vector<int> count(26, 0);
        for (char c : s) {
            count[c - 'a']++;
        }
        string ans = "";
        for (int i = n - 1; i >= 0; i--) {
            int c = s[i] - 'a';
            if (count[c] == 0) continue;
            count[c]--;
            int l = ans.length();
            if (l >= repeatLimit && ans[l - repeatLimit] == s[i]) continue;
            ans += s[i];
        }
        return ans;
    }
};