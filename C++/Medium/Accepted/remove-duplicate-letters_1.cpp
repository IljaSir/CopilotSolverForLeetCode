class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int n = s.size();
        vector<int> cnt(26, 0);
        for (char c : s) {
            cnt[c - 'a']++;
        }
        vector<bool> vis(26, false);
        string ans = "0";
        for (char c : s) {
            cnt[c - 'a']--;
            if (vis[c - 'a']) {
                continue;
            }
            while (c < ans.back() && cnt[ans.back() - 'a'] > 0) {
                vis[ans.back() - 'a'] = false;
                ans.pop_back();
            }
            ans.push_back(c);
            vis[c - 'a'] = true;
        }
        return ans.substr(1);
    }
};