class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> out;
        int freq[26] = {0};
        for (string word: words2) {
            int f[26] = {0};
            for (char c: word) {
                f[c-'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                freq[i] = max(freq[i], f[i]);
            }
        }
        for (string word: words1) {
            int f[26] = {0};
            for (char c: word) {
                f[c-'a']++;
            }
            bool flag = true;
            for (int i = 0; i < 26; ++i) {
                if (f[i] < freq[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                out.push_back(word);
            }
        }
        return out;
    }
};