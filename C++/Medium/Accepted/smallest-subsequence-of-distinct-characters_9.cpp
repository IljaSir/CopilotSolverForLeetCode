class Solution {
public:
    string smallestSubsequence(string s) {
        
        int n = s.length();
        vector<int> cnt(26);
        for (char ch: s) cnt[ch-'a']++;
        vector<bool> vis(26);
        string ans = "0";
        for (char ch: s) {
            cnt[ch-'a']--;
            if (vis[ch-'a']) continue;
            while (ch < ans.back() && cnt[ans.back()-'a']) {
                vis[ans.back()-'a'] = false;
                ans.pop_back();
            }
            ans += ch;
            vis[ch-'a'] = true;
        }
        return ans.substr(1);
    }
};