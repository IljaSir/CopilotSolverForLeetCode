class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        
        vector<string> result;
        for (const string& query : queries) {
            for (const string& dict : dictionary) {
                if (query.size() == dict.size()) {
                    if (oneEditWord(query, dict)) {
                        result.push_back(query);
                        break;
                    }
                } else if (query.size() == dict.size() + 1) {
                    if (oneEditWord(dict, query)) {
                        result.push_back(query);
                        break;
                    }
                } else if (query.size() == dict.size() - 1) {
                    if (oneEditWord(query, dict)) {
                        result.push_back(query);
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    bool oneEditWord(const string& s1, const string& s2) {
        int count = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] != s2[i]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
};