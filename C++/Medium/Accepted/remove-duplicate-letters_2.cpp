class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        string res;
        vector<int> cnt(26, 0), visited(26, 0);
        for (char c : s) {
            ++cnt[c - 'a'];
        }
        for (char c : s) {
            --cnt[c - 'a'];
            if (visited[c - 'a']) {
                continue;
            }
            while (!res.empty() && c < res.back() && cnt[res.back() - 'a'] > 0) {
                visited[res.back() - 'a'] = 0;
                res.pop_back();
            }
            res.push_back(c);
            visited[c - 'a'] = 1;
        }
        return res;
    }
};