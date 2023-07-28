class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
        
        vector<int> res(s.size());
        int pre = -10000;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == c) pre = i;
            res[i] = i - pre;
        }
        pre = 10000;
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == c) pre = i;
            res[i] = min(res[i], pre - i);
        }
        return res;
    }
};