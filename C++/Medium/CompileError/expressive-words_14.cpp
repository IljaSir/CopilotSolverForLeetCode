class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int res = 0;
        for (auto word : words) {
            if (isStretchy(s, word)) {
                ++res;
            }
        }
        return res;
    }
};