class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int n = s.size();
        int last[26];
        bool vis[26];
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i;
        }
        string ans = "";
        for (int i = 0; i < n; i++) {
            if (vis[s[i] - 'a']) continue;
            while (!ans.empty() && ans.back() > s[i] && last[ans.back() - 'a'] > i) {
                vis[ans.back() - 'a'] = false;
                ans.pop_back();
            }
            ans += s[i];
            vis[s[i] - 'a'] = true;
        }
        return ans;
    }
};