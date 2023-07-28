class Solution {
public:
    string getSmallestString(int n, int k) {
        
        string s;
        for (int i = 0; i < n; ++i) {
            s += 'a';
        }
        k -= n;
        int i = n - 1;
        while (k > 0) {
            int d = min(k, 25);
            s[i] += d;
            k -= d;
            --i;
        }
        return s;
    }
};