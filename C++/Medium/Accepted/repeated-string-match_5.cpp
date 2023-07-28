class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        int n = a.size();
        int m = b.size();
        int k = 0;
        string s = "";
        while (s.size() < m) {
            s += a;
            k++;
        }
        if (s.find(b) != string::npos) return k;
        s += a;
        k++;
        if (s.find(b) != string::npos) return k;
        return -1;
    }
};