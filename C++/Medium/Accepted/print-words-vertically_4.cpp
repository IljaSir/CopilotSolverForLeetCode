class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> words;
        int n = s.size();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s[j] != ' ') {
                ++j;
            }
            string word = s.substr(i, j - i);
            words.push_back(word);
            i = j + 1;
        }
        int m = words.size();
        int maxLen = 0;
        for (int i = 0; i < m; ++i) {
            maxLen = max(maxLen, (int)words[i].size());
        }
        vector<string> ans(maxLen);
        for (int i = 0; i < maxLen; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i < words[j].size()) {
                    ans[i] += words[j][i];
                } else {
                    ans[i] += ' ';
                }
            }
            while (ans[i].back() == ' ') {
                ans[i].pop_back();
            }
        }
        return ans;
    }
};