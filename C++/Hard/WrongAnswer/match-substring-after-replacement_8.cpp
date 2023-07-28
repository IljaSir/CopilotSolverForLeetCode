class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        bool result = false;
        if (s.empty() || sub.empty() || mappings.empty()) {
            return result;
        }
        if (s.size() < sub.size()) {
            return result;
        }
        unordered_map<char, char> mappingMap;
        for (auto mapping : mappings) {
            mappingMap[mapping[0]] = mapping[1];
        }
        for (int i = 0; i <= s.size() - sub.size(); ++i) {
            int j = 0;
            for (; j < sub.size(); ++j) {
                if (s[i + j] != sub[j]) {
                    if (mappingMap.find(sub[j]) != mappingMap.end()) {
                        if (mappingMap[sub[j]] != s[i + j]) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (j == sub.size()) {
                result = true;
                break;
            }
        }
        return result;
    }
};