class Solution {
public:
    vector<int> diStringMatch(string s) {
        
        int n = s.size();
        int left = 0;
        int right = n;
        vector<int> res;
        for (int i = 0; i < n; ++i) {
            if (s[i] == 'I') {
                res.push_back(left++);
            } else {
                res.push_back(right--);
            }
        }
        res.push_back(left);
        return res;
    }
};