class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        unordered_map<string, int> prefixScores;
        for (string word : words) {
            for (int i = 0; i < word.size(); i++) {
                prefixScores[word.substr(0, i + 1)]++;
            }
        }
        vector<int> result;
        for (string word : words) {
            result.push_back(prefixScores[word]);
        }
        return result;
    }
};