class Solution {
public:
    string smallestNumber(string pattern) {
        
        int n = pattern.size();
        string ret(n + 1, ' ');
        int lo = 0, hi = n;
        for (int i = 0; i < n; ++i) {
            if (pattern[i] == 'I') {
                ret[i] = lo + '0';
                lo++;
            } else {
                ret[i] = hi + '0';
                hi--;
            }
        }
        ret[n] = lo + '0';
        return ret;
    }
};