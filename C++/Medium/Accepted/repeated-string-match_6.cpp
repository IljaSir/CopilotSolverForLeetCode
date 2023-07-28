class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        int n = a.size();
        int m = b.size();
        int q = (m+n-1)/n;
        string s = a;
        for (int i = 1; i < q; i++) {
            s += a;
        }
        if (s.find(b) != string::npos) {
            return q;
        }
        s += a;
        if (s.find(b) != string::npos) {
            return q+1;
        }
        return -1;
    }
};