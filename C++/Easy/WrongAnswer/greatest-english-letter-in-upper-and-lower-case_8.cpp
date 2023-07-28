class Solution {
public:
    string greatestLetter(string s) {
        
        string ans = "";
        unordered_map<char, int> m;
        for (char c : s) {
            m[c]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (m.find(tolower(it->first)) != m.end() && m.find(toupper(it->first)) != m.end()) {
                ans = it->first;
            }
        }
        return ans;
    }
};