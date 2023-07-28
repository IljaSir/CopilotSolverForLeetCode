class Solution {
public:
    string smallestNumber(string pattern) {
        
        int n = pattern.size();
        int l = 0, r = n;
        string res = "";
        for (int i = 0; i < n; i++) {
            if (pattern[i] == 'I') {
                res += to_string(l);
                l++;
            } else {
                res += to_string(r);
                r--;
            }
        }
        res += to_string(l);
        return res;
    }
};