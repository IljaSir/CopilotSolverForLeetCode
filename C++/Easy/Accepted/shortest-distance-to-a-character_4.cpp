class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        vector<int> res;
        int n = s.size();
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (s[i] == c) pos = i;
            res.push_back(i - pos);
        }
        for (int i = pos - 1; i >= 0; --i) {
            if (s[i] == c) pos = i;
            res[i] = min(res[i], pos - i);
        }
        return res;
    }
};