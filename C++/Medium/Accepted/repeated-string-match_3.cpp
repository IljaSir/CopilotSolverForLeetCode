class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        int n = a.size(), m = b.size();
        int ans = 0;
        string s;
        while (s.size() < m) {
            s += a;
            ans++;
        }
        if (s.find(b) != string::npos) return ans;
        s += a;
        ans++;
        if (s.find(b) != string::npos) return ans;
        return -1;
    }
};