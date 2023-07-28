class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        int n = s.size();
        int prev = -n;
        vector<int> res(n);
        for (int i = 0; i < n; i++) {
            if (s[i] == c) prev = i;
            res[i] = i - prev;
        }
        for (int i = prev - 1; i >= 0; i--) {
            if (s[i] == c) prev = i;
            res[i] = min(res[i], prev - i);
        }
        return res;
    }
};