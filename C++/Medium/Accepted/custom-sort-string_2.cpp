class Solution {
public:
    string customSortString(string order, string s) {
        
        map<char, int> m;
        for (int i = 0; i < order.length(); ++i) {
            m[order[i]] = i;
        }
        sort(s.begin(), s.end(), [&](char a, char b) {
            if (m.find(a) == m.end() && m.find(b) == m.end()) {
                return a < b;
            }
            if (m.find(a) == m.end()) {
                return false;
            }
            if (m.find(b) == m.end()) {
                return true;
            }
            return m[a] < m[b];
        });
        return s;
    }
};