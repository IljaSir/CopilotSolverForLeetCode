class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        
        unordered_set<string> dict(dictionary.begin(), dictionary.end());
        vector<string> res;
        for (auto& word: queries) {
            if (dict.count(word) > 0) {
                res.push_back(word);
                continue;
            }
            for (auto& w: dict) {
                if (w.size() != word.size()) continue;
                if (isOneEditAway(w, word)) {
                    res.push_back(word);
                    break;
                }
            }
        }
        return res;
    }
    
    bool isOneEditAway(string& w1, string& w2) {
        int diff = 0;
        for (int i = 0; i < w1.size(); i++) {
            if (w1[i] != w2[i]) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }
};