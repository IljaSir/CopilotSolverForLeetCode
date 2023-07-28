class Solution {
public:
    string longestWord(vector<string>& words) {
        
        sort(words.begin(), words.end());
        unordered_set<string> s;
        string res;
        for (string word : words) {
            if (word.length() == 1 || s.count(word.substr(0, word.length() - 1))) {
                res = word.length() > res.length() ? word : res;
                s.insert(word);
            }
        }
        return res;
    }
};