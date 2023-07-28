class Solution {
public:
    vector<int> diStringMatch(string s) {
        
        int n = s.size();
        int i = 0;
        int d = n;
        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'I') {
                res.push_back(i);
            } else {
                res.push_back(d--);
            }
        }
        res.push_back(d);
        return res;
    }
};