class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        string ans;
        for (auto& word : dictionary) {
            int i = 0;
            for (auto& c : s) {
                if (i < word.size() && c == word[i]) {
                    ++i;
                }
            }
            if (i == word.size() && (ans.size() < word.size() || (ans.size() == word.size() && ans > word))) {
                ans = word;
            }
        }
        return ans;
    }
};