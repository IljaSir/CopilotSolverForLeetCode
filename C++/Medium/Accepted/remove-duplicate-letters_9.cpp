class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int n = s.size();
        string res = "";
        vector<int> cnt(26);
        vector<bool> vis(26);
        for (auto c : s) {
            cnt[c - 'a']++;
        }
        for (auto c : s) {
            cnt[c - 'a']--;
            if (vis[c - 'a']) continue;
            while (!res.empty() && res.back() > c && cnt[res.back() - 'a'] > 0) {
                vis[res.back() - 'a'] = false;
                res.pop_back();
            }
            res.push_back(c);
            vis[c - 'a'] = true;
        }
        return res;
    }
};