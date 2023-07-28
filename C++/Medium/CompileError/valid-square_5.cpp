class Solution {
public:
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        
        vector<int> d(6);
        d[0] = dist(p1, p2);
        d[1] = dist(p1, p3);
        d[2] = dist(p1, p4);
        d[3] = dist(p2, p3);
        d[4] = dist(p2, p4);
        d[5] = dist(p3, p4);
        sort(d.begin(), d.end());
        return d[0] == d[1] && d[1] == d[2] && d[2] == d[3] && d[4] == d[5] && d[0] != d[4];
    }
};