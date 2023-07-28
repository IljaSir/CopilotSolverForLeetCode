class Solution {
public:
    vector<int> diStringMatch(string s) {
        
        int n = s.size();
        vector<int> res;
        int low = 0, high = n;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'I') {
                res.push_back(low++);
            } else {
                res.push_back(high--);
            }
        }
        res.push_back(low);
        return res;
    }
};