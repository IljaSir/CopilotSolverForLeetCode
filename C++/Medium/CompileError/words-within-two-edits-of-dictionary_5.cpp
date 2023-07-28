class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        
        unordered_set<string> dict(dictionary.begin(), dictionary.end());
        vector<string> res;
        for (string& query : queries) {
            if (dict.count(query) || findOneEdit(query, dict) || findTwoEdits(query, dict)) {
                res.push_back(query);
            }
        }
        return res;
    }
};