class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        unordered_map<string, int> m;
        for (auto& c : paragraph) {
            if (c >= 'A' && c <= 'Z') c += 32;
            if (c < 'a' || c > 'z') c = ' ';
        }
        istringstream iss(paragraph);
        string word;
        while (iss >> word) {
            if (find(banned.begin(), banned.end(), word) == banned.end()) {
                ++m[word];
            }
        }
        string res;
        int maxCnt = 0;
        for (auto& [w, c] : m) {
            if (c > maxCnt) {
                maxCnt = c;
                res = w;
            }
        }
        return res;
    }
};