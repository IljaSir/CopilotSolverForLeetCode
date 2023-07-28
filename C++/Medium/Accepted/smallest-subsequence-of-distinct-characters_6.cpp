class Solution {
public:
    string smallestSubsequence(string s) {
        
        string ans;
        int n = s.size();
        vector<int> cnt(26, 0), used(26, 0);
        for (auto c : s) cnt[c - 'a']++;
        for (auto c : s) {
            cnt[c - 'a']--;
            if (used[c - 'a']) continue;
            while (!ans.empty() && ans.back() > c && cnt[ans.back() - 'a']) {
                used[ans.back() - 'a'] = 0;
                ans.pop_back();
            }
            ans.push_back(c);
            used[c - 'a'] = 1;
        }
        return ans;
    }
};