class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> original;
        if (changed.size() % 2 != 0) return original;
        map<int, int> m;
        for (int i = 0; i < changed.size(); i++) {
            if (m.find(changed[i]) == m.end()) {
                m[changed[i]] = 1;
            } else {
                m[changed[i]]++;
            }
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second == 0) continue;
            if (it->first == 0 && it->second % 2 != 0) return original;
            if (it->first == 0 && it->second % 2 == 0) {
                it->second = 0;
                for (int i = 0; i < it->second / 2; i++) {
                    original.push_back(0);
                }
                continue;
            }
            if (m.find(it->first * 2) == m.end()) return original;
            if (m[it->first * 2] < it->second) return original;
            m[it->first * 2] -= it->second;
            it->second = 0;
            for (int i = 0; i < it->second; i++) {
                original.push_back(it->first);
            }
        }
        return original;
    }
};