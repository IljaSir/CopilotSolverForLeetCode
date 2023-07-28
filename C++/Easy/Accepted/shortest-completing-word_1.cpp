class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        vector<int> charCount(26, 0);
        for (char c : licensePlate) {
            if (isalpha(c)) {
                charCount[tolower(c) - 'a']++;
            }
        }
        string res;
        for (string w : words) {
            vector<int> count(charCount);
            for (char c : w) {
                if (isalpha(c)) {
                    count[tolower(c) - 'a']--;
                }
            }
            if (all_of(count.begin(), count.end(), [](int x) { return x <= 0; })) {
                if (res.empty() || res.size() > w.size()) {
                    res = w;
                }
            }
        }
        return res;
    }
};