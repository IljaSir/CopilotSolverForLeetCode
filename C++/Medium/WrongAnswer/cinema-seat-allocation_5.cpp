class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        int res = n * 2;
        map<int, vector<int>> m;
        for (auto &v: reservedSeats) {
            m[v[0]].push_back(v[1]);
        }
        for (auto &p: m) {
            vector<int> &v = p.second;
            bool l = false, r = false;
            for (auto &x: v) {
                if (x >= 2 && x <= 5) l = true;
                if (x >= 6 && x <= 9) r = true;
            }
            if (l && r) res -= 2;
            else if (l || r) res -= 1;
        }
        return res;
    }
};