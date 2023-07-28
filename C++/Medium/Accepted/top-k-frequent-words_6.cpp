class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        map<string, int> wordCount;
        for (string word : words) {
            wordCount[word]++;
        }
        vector<string> result;
        for (auto it = wordCount.begin(); it != wordCount.end(); it++) {
            result.push_back(it->first);
        }
        sort(result.begin(), result.end(), [&wordCount](const string &w1, const string &w2) {
            return wordCount[w1] > wordCount[w2] || (wordCount[w1] == wordCount[w2] && w1 < w2);
        });
        result.resize(k);
        return result;
    }
};