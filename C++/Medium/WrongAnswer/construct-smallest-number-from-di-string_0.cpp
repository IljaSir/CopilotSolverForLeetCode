class Solution {
public:
    string smallestNumber(string pattern) {
        
        int n = pattern.size();
        string res;
        int l = 0, r = n;
        for (int i = 0; i < n; ++i) {
            if (pattern[i] == 'I') {
                res += to_string(l++);
            } else {
                res += to_string(r--);
            }
        }
        res += to_string(l);
        return res;
    }
};