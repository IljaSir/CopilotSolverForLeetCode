class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        unordered_map<string, int> freq;
        string word;
        for (auto c : paragraph) {
            if (isalpha(c)) {
                word += tolower(c);
            } else if (!word.empty()) {
                freq[word]++;
                word = "";
            }
        }
        if (!word.empty()) {
            freq[word]++;
        }
        string res;
        int maxFreq = 0;
        for (auto& [w, f] : freq) {
            if (f > maxFreq && find(banned.begin(), banned.end(), w) == banned.end()) {
                maxFreq = f;
                res = w;
            }
        }
        return res;
    }
};