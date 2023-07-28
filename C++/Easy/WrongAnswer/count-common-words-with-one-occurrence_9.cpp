class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> word_count;
        for (auto word : words1) {
            word_count[word]++;
        }
        for (auto word : words2) {
            word_count[word]++;
        }
        int result = 0;
        for (auto pair : word_count) {
            if (pair.second == 1) {
                result++;
            }
        }
        return result;
    }
};