class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        int count[26] = {0};
        for (auto c : licensePlate) {
            if (isalpha(c)) {
                count[tolower(c) - 'a']++;
            }
        }
        string ans;
        for (auto &word : words) {
            int tmp[26] = {0};
            for (auto c : word) {
                tmp[c - 'a']++;
            }
            bool ok = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] > tmp[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (ans.empty() || ans.size() > word.size())) {
                ans = word;
            }
        }
        return ans;
    }
};