class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        vector<int> charCount(26, 0);
        for (auto c : licensePlate) {
            if (isalpha(c)) {
                charCount[tolower(c) - 'a']++;
            }
        }
        string res = "";
        for (auto word : words) {
            vector<int> count(26, 0);
            for (auto c : word) {
                count[c - 'a']++;
            }
            bool flag = true;
            for (int i = 0; i < 26; i++) {
                if (charCount[i] > count[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (res == "" || res.size() > word.size()) {
                    res = word;
                }
            }
        }
        return res;
    }
};