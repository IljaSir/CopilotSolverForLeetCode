class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        unordered_map<string, int> wordCount;
        for (auto& word : words) {
            wordCount[word]++;
        }
        vector<vector<string>> bucket(words.size() + 1);
        for (auto& [word, count] : wordCount) {
            bucket[count].push_back(word);
        }
        vector<string> result;
        for (int i = bucket.size() - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i].empty()) {
                continue;
            }
            sort(bucket[i].begin(), bucket[i].end());
            for (int j = 0; j < bucket[i].size() && result.size() < k; j++) {
                result.push_back(bucket[i][j]);
            }
        }
        return result;
    }
};