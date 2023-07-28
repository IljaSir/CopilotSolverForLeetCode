class Solution {
public:
    string longestWord(vector<string>& words) {
        
        unordered_set<string> dict(words.begin(), words.end());
        sort(words.begin(), words.end(), [](string& a, string& b) {
            if (a.size() == b.size()) {
                return a < b;
            }
            return a.size() > b.size();
        });
        for (string& word : words) {
            bool ok = true;
            for (int i = 1; i < word.size(); i++) {
                if (dict.find(word.substr(0, i)) == dict.end()) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return word;
            }
        }
        return "";
    }
};