class Solution {
public:
    bool equalFrequency(string word) {
        
        map<char, int> m;
        for (char c: word) {
            m[c]++;
        }
        if (m.size() == 1) {
            return true;
        }
        if (m.size() == 2) {
            auto it = m.begin();
            int v1 = it->second;
            it++;
            int v2 = it->second;
            if (v1 == 1 || v2 == 1) {
                return true;
            }
        }
        if (m.size() == word.size()) {
            return false;
        }
        map<int, int> freq;
        for (auto it: m) {
            freq[it.second]++;
        }
        if (freq.size() == 1) {
            return true;
        }
        if (freq.size() == 2) {
            auto it = freq.begin();
            int v1 = it->second;
            it++;
            int v2 = it->second;
            if (v1 == 1 || v2 == 1) {
                return true;
            }
        }
        return false;
    }
};