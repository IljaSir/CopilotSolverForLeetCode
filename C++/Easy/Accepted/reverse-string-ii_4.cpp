class Solution {
public:
    string reverseStr(string s, int k) {
        
        int n = s.size();
        int i = 0;
        while (i < n) {
            int j = min(i + k, n);
            reverse(s.begin() + i, s.begin() + j);
            i += 2 * k;
        }
        return s;
    }
};