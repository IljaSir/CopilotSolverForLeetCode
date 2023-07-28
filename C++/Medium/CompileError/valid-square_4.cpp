class Solution {
public:
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        
        vector<int> v{dist(p1, p2), dist(p1, p3), dist(p1, p4), dist(p2, p3), dist(p2, p4), dist(p3, p4)};
        sort(v.begin(), v.end());
        return v[0] > 0 && v[0] == v[1] && v[1] == v[2] && v[2] == v[3] && v[4] == v[5];
    }
};