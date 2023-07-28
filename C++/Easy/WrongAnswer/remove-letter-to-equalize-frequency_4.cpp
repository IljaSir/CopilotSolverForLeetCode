class Solution {
public:
    bool equalFrequency(string word) {
        
        map<char, int> m;
        for (auto c: word) {
            m[c]++;
        }
        map<int, int> f;
        for (auto& p: m) {
            f[p.second]++;
        }
        if (f.size() == 1) {
            return true;
        }
        if (f.size() == 2) {
            auto it = f.begin();
            if (it->first == 1 && it->second == 1) {
                return true;
            }
            auto it2 = it;
            it2++;
            if (it2->first - it->first == 1 && it2->second == 1) {
                return true;
            }
        }
        return false;
    }
};