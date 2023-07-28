class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int n = words.size();
        int m = chars.size();
        vector<int> cnt(26, 0);
        for (int i = 0; i < m; ++i) {
            ++cnt[chars[i] - 'a'];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            vector<int> tmp = cnt;
            int j = 0;
            for (; j < words[i].size(); ++j) {
                if (tmp[words[i][j] - 'a'] == 0) {
                    break;
                }
                --tmp[words[i][j] - 'a'];
            }
            if (j == words[i].size()) {
                res += j;
            }
        }
        return res;
    }
};