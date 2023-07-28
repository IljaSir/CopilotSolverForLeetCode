class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        int n = s.length();
        vector<int> res(n, 0);
        int lastC = -n;
        for (int i = 0; i < n; i++) {
            if (s[i] == c) lastC = i;
            res[i] = i - lastC;
        }
        for (int i = lastC - 1; i >= 0; i--) {
            if (s[i] == c) lastC = i;
            res[i] = min(res[i], lastC - i);
        }
        return res;
    }
};