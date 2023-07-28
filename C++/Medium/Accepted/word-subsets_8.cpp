class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> result;
        vector<int> cnts(26, 0);
        for (string& word : words2) {
            vector<int> cnts2(26, 0);
            for (char c : word) {
                cnts2[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                cnts[i] = max(cnts[i], cnts2[i]);
            }
        }
        for (string& word : words1) {
            vector<int> cnts2(26, 0);
            for (char c : word) {
                cnts2[c - 'a']++;
            }
            bool isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (cnts2[i] < cnts[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.push_back(word);
            }
        }
        return result;
    }
};