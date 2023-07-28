class Solution {
public:
    string smallestSubsequence(string s) {
        
        vector<int> cnt(26);
        vector<bool> seen(26);
        for (char c : s) {
            cnt[c - 'a']++;
        }
        string res;
        for (char c : s) {
            if (!seen[c - 'a']) {
                while (!res.empty() && c < res.back() && cnt[res.back() - 'a'] > 0) {
                    seen[res.back() - 'a'] = false;
                    res.pop_back();
                }
                res.push_back(c);
                seen[c - 'a'] = true;
            }
            cnt[c - 'a']--;
        }
        return res;
    }
};