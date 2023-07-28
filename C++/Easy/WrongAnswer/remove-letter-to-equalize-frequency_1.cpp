class Solution {
public:
    bool equalFrequency(string word) {
        
        unordered_map<char, int> m;
        for (char c : word) {
            m[c]++;
        }
        unordered_map<int, int> m2;
        for (auto& [k, v] : m) {
            m2[v]++;
        }
        if (m2.size() == 1) {
            return true;
        }
        if (m2.size() == 2) {
            auto it = m2.begin();
            if (it->second == 1 && it->first == 1) {
                return true;
            }
            if (it->second == 1 && it->first - (++it)->first == 1) {
                return true;
            }
            if (it->second == 1 && (++it)->first == 1) {
                return true;
            }
        }
        return false;
    }
};