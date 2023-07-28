class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        unordered_map<char, vector<int>> m;
        for (int i = 0; i < s.size(); ++i) {
            m[s[i]].push_back(i);
        }
        for (int i = 0; i < 26; ++i) {
            char c = 'a' + i;
            if (m.find(c) == m.end()) {
                continue;
            }
            vector<int> pos = m[c];
            for (int j = 1; j < pos.size(); ++j) {
                if (pos[j] - pos[j - 1] - 1 != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
};