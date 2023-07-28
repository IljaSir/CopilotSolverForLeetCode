class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> res;
        vector<int> count(26, 0);
        for (string word : words2) {
            vector<int> tmp(26, 0);
            for (char c : word) tmp[c - 'a']++;
            for (int i = 0; i < 26; i++) {
                count[i] = max(count[i], tmp[i]);
            }
        }
        for (string word : words1) {
            vector<int> tmp(26, 0);
            for (char c : word) tmp[c - 'a']++;
            bool ok = true;
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < count[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) res.push_back(word);
        }
        return res;
    }
};