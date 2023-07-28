class Solution {
public:
    vector<int> diStringMatch(string s) {
        
        int n = s.length();
        vector<int> res;
        int left = 0, right = n;
        for (int i = 0; i < n; ++i) {
            if (s[i] == 'I') {
                res.push_back(left);
                ++left;
            } else {
                res.push_back(right);
                --right;
            }
        }
        res.push_back(left);
        return res;
    }
};