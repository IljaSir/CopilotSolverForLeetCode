class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        
        for (auto& c : paragraph) {
            if (ispunct(c)) {
                c = ' ';
            }
        }
        for (auto& c : paragraph) {
            if (isupper(c)) {
                c = tolower(c);
            }
        }
        std::istringstream iss(paragraph);
        std::string s;
        std::unordered_map<std::string, int> m;
        while (iss >> s) {
            ++m[s];
        }
        for (auto& b : banned) {
            m.erase(b);
        }
        std::pair<std::string, int> res;
        for (auto& p : m) {
            if (p.second > res.second) {
                res = p;
            }
        }
        return res.first;
    }
};