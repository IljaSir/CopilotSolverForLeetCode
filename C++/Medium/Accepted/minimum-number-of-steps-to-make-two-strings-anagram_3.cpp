class Solution {
public:
    int minSteps(string s, string t) {
        
        int n = s.size();
        vector<int> count(26, 0);
        for (int i = 0; i < n; ++i) {
            ++count[s[i] - 'a'];
            --count[t[i] - 'a'];
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                res += count[i];
            }
        }
        return res;
    }
};