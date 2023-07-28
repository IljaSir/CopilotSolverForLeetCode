class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        string ans = "";
        for (string word : dictionary) {
            int i = 0;
            for (char c : s) {
                if (i < word.size() && c == word[i]) {
                    i++;
                }
            }
            if (i == word.size() && word.size() >= ans.size()) {
                if (word.size() > ans.size() || word < ans) {
                    ans = word;
                }
            }
        }
        return ans;
    }
};