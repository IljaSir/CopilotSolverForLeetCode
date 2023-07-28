class Solution {
public:
    string customSortString(string order, string s) {
        
        string res;
        unordered_map<char, int> m;
        for (int i = 0; i < s.size(); i++) {
            m[s[i]]++;
        }
        for (int i = 0; i < order.size(); i++) {
            if (m.find(order[i]) != m.end()) {
                for (int j = 0; j < m[order[i]]; j++) {
                    res += order[i];
                }
                m.erase(order[i]);
            }
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            for (int i = 0; i < it->second; i++) {
                res += it->first;
            }
        }
        return res;
    }
};