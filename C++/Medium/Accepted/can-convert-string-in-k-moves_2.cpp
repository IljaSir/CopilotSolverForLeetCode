class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.size() != t.size()) return false;
        unordered_map<int, int> m;
        for (int i = 0; i < s.size(); ++i) {
            int d = (t[i] - s[i] + 26) % 26;
            if (d) {
                if (d + 26 * m[d] > k) return false;
                ++m[d];
            }
        }
        return true;
    }
};