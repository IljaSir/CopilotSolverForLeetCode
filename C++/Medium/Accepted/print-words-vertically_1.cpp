class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> words;
        string word;
        for (char c : s) {
            if (c == ' ') {
                words.push_back(word);
                word.clear();
            } else {
                word += c;
            }
        }
        words.push_back(word);
        int max_len = 0;
        for (auto& w : words) {
            max_len = max(max_len, (int)w.length());
        }
        vector<string> ans(max_len);
        for (int i = 0; i < max_len; i++) {
            for (auto& w : words) {
                if (i < w.length()) {
                    ans[i] += w[i];
                } else {
                    ans[i] += ' ';
                }
            }
            while (!ans[i].empty() && ans[i].back() == ' ')
                ans[i].pop_back();
        }
        return ans;
    }
};