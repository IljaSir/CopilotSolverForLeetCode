class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int n = s.size();
        string ans;
        vector<int> cnt(26, 0);
        vector<bool> vis(26, false);
        for (char c : s) cnt[c - 'a']++;
        for (char c : s) {
            cnt[c - 'a']--;
            if (vis[c - 'a']) continue;
            while (!ans.empty() && ans.back() > c && cnt[ans.back() - 'a']) {
                vis[ans.back() - 'a'] = false;
                ans.pop_back();
            }
            ans.push_back(c);
            vis[c - 'a'] = true;
        }
        return ans;
    }
};