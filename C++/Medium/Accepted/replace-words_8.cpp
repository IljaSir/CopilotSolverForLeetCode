class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        unordered_set<string> s;
        for (auto& w : dictionary) {
            s.insert(w);
        }
        string res;
        istringstream ss(sentence);
        string word;
        while (ss >> word) {
            string prefix;
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substr(0, i);
                if (s.find(prefix) != s.end()) {
                    break;
                }
            }
            if (!res.empty()) {
                res += " ";
            }
            res += prefix;
        }
        return res;
    }
};