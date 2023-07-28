class Solution {
public:
    string greatestLetter(string s) {
        
        int n = s.size();
        vector<int> v(52, 0);
        for (int i = 0; i < n; i++) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                v[s[i] - 'a']++;
            } else {
                v[s[i] - 'A' + 26]++;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (v[i] > 0 && v[i + 26] > 0) {
                return string(1, 'A' + i);
            }
        }
        return "";
    }
};