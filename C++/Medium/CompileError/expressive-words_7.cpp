class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int count = 0;
        for (string word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }
    bool isStretchy(string s, string word) {
        int i = 0, j = 0; j == word.size();
    }
};