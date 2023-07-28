class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        string res;
        for (auto& word: sentence) {
            if (word == ' ') {
                res.push_back(word);
                continue;
            }
            string tmp;
            for (auto& dic: dictionary) {
                if (word.find(dic) == 0) {
                    if (tmp.empty() || tmp.size() > dic.size()) {
                        tmp = dic;
                    }
                }
            }
            if (tmp.empty()) {
                res.push_back(word);
            } else {
                res += tmp;
            }
        }
        return res;
    }
};