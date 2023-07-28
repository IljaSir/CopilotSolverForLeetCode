class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        vector<int> lp(26, 0);
        for (auto c : licensePlate) {
            if (isalpha(c)) {
                lp[tolower(c) - 'a']++;
            }
        }
        string result = "";
        for (auto& word : words) {
            if (word.length() < result.length() || result.length() == 0) {
                vector<int> wp(26, 0);
                for (auto c : word) {
                    wp[c - 'a']++;
                }
                bool ok = true;
                for (int i = 0; i < 26; i++) {
                    if (lp[i] > wp[i]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    result = word;
                }
            }
        }
        return result;
    }
};