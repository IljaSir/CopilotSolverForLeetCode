class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> res;
        vector<string> words;
        istringstream iss(s);
        string word;
        while (iss >> word) {
            words.push_back(word);
        }
        int maxLen = 0;
        for (auto& w : words) {
            maxLen = max(maxLen, (int)w.length());
        }
        for (int i = 0; i < maxLen; i++) {
            res.push_back("");
            for (int j = 0; j < words.size(); j++) {
                if (i < words[j].length()) {
                    res[i] += words[j][i];
                } else {
                    res[i] += " ";
                }
            }
            while (res[i].length() > 0 && res[i][res[i].length() - 1] == ' ') {
                res[i].pop_back();
            }
        }
        return res;
    }
};