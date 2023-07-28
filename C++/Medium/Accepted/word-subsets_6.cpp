class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> result;
        vector<int> maxCount(26, 0);
        for (auto w : words2) {
            vector<int> count = countLetters(w);
            for (int i = 0; i < 26; ++i) {
                maxCount[i] = max(maxCount[i], count[i]);
            }
        }
        for (auto w : words1) {
            vector<int> count = countLetters(w);
            bool isUniversal = true;
            for (int i = 0; i < 26; ++i) {
                if (count[i] < maxCount[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.push_back(w);
            }
        }
        return result;
    }
    
    vector<int> countLetters(string word) {
        vector<int> count(26, 0);
        for (auto c : word) {
            count[c - 'a']++;
        }
        return count;
    }
};