class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.size() != t.size()) {
            return false;
        }
        vector<int> diff(26, 0);
        for (int i = 0; i < s.size(); i++) {
            int d = (t[i] - s[i] + 26) % 26;
            diff[d]++;
        }
        for (int i = 1; i < 26; i++) {
            if (diff[i] * 26 + i > k) {
                return false;
            }
        }
        return true;
    }
};