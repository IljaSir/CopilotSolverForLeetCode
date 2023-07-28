class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        
        vector<string> result;
        for (auto& query : queries) {
            for (auto& word : dictionary) {
                if (query.size() == word.size()) {
                    if (oneEdit(query, word)) {
                        result.push_back(query);
                        break;
                    }
                } else if (query.size() == word.size() + 1) {
                    if (oneEdit(word, query)) {
                        result.push_back(query);
                        break;
                    }
                } else if (query.size() + 1 == word.size()) {
                    if (oneEdit(query, word)) {
                        result.push_back(query);
                        break;
                    }
                }
            }
        }
        return result;
    }
    bool oneEdit(string& s1, string& s2) {
        int count = 0;
        for (int i = 0, j = 0; i < s1.size() && j < s2.size(); ) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                count++;
                if (count > 1) {
                    return false;
                }
                if (s1.size() > s2.size()) {
                    i++;
                } else if (s1.size() < s2.size()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return true;
    }
};