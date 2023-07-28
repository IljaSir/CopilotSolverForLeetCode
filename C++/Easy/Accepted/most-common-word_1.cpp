class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        unordered_map<string, int> count;
        for (auto &ch : paragraph) {
            ch = isalpha(ch) ? tolower(ch) : ' ';
        }
        istringstream iss(paragraph);
        string word;
        while (iss >> word) {
            count[word]++;
        }
        for (auto &ban : banned) {
            count[ban] = 0;
        }
        string res;
        for (auto &[k, v] : count) {
            if (v > count[res]) {
                res = k;
            }
        }
        return res;
    }
};