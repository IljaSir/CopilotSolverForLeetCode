class Solution {
public:
    vector<int> diStringMatch(string s) {
        
        int n = s.size();
        vector<int> v;
        int l = 0, r = n;
        for (auto c : s) {
            if (c == 'I') {
                v.push_back(l);
                l++;
            } else {
                v.push_back(r);
                r--;
            }
        }
        v.push_back(l);
        return v;
    }
};