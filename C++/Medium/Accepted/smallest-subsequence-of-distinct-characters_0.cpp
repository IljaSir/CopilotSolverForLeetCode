class Solution {
public:
    string smallestSubsequence(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i;
        }
        vector<bool> seen(26, false);
        string res;
        for (int i = 0; i < n; i++) {
            if (seen[s[i] - 'a']) continue;
            while (!res.empty() && res.back() > s[i] && last[res.back() - 'a'] > i) {
                seen[res.back() - 'a'] = false;
                res.pop_back();
            }
            seen[s[i] - 'a'] = true;
            res.push_back(s[i]);
        }
        return res;
    }
};