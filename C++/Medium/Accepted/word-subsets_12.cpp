class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<int> maxLetters(26);
        for (string word : words2) {
            vector<int> letters(26);
            for (char c : word) {
                letters[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxLetters[i] = max(maxLetters[i], letters[i]);
            }
        }
        
        vector<string> ans;
        for (string word : words1) {
            vector<int> letters(26);
            for (char c : word) {
                letters[c - 'a']++;
            }
            bool isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (letters[i] < maxLetters[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                ans.push_back(word);
            }
        }
        return ans;
    }
};