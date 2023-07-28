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
                word.push_back(c);
            }
        }
        words.push_back(word);
        vector<string> res;
        for (int i = 0; i < words.size(); i++) {
            string w = words[i];
            while (w.size() < s.size()) w.push_back(' ');
            if (res.empty()) {
                res.push_back(w);
            } else {
                for (int j = 0; j < w.size(); j++) {
                    res[j].push_back(w[j]);
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            while (res[i].back() == ' ') res[i].pop_back();
        }
        return res;
    }
};