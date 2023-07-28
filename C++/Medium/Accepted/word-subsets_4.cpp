class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> result;
        vector<int> count(26, 0);
        for (auto& word : words2) {
            vector<int> tmp(26, 0);
            for (auto& c : word) {
                tmp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = max(count[i], tmp[i]);
            }
        }
        for (auto& word : words1) {
            vector<int> tmp(26, 0);
            for (auto& c : word) {
                tmp[c - 'a']++;
            }
            bool flag = true;
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < count[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.push_back(word);
        }
        return result;
    }
};