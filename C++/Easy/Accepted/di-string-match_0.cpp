class Solution {
public:
    vector<int> diStringMatch(string s) {
        
        int n = s.size();
        int low = 0, high = n;
        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'I') {
                res.push_back(low);
                low++;
            } else {
                res.push_back(high);
                high--;
            }
        }
        res.push_back(high);
        return res;
    }
};