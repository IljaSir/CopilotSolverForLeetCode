class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
        
        for (int i = 0; i < words.size(); i++) {
            reverse(words[i].begin(), words[i].end());
        }
        sort(words.begin(), words.end());
        int res = 0;
        for (int i = 0; i < words.size(); i++) {
            if (i == words.size() - 1 || words[i] != words[i + 1].substr(0, words[i].size())) {
                res += words[i].size() + 1;
            }
        }
        return res;
    }
};