class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        vector<int> res;
        int prev = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == c) {
                prev = i;
            }
            if(prev == -1) {
                res.push_back(INT_MAX);
            } else {
                res.push_back(i - prev);
            }
        }
        prev = -1;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s[i] == c) {
                prev = i;
            }
            if(prev == -1) {
                res[i] = INT_MAX;
            } else {
                res[i] = min(res[i], prev - i);
            }
        }
        return res;
    }
};