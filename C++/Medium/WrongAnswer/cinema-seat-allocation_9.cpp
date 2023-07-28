class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        int ret = 0;
        unordered_map<int, vector<int>> m;
        for (auto &v : reservedSeats) {
            m[v[0]].push_back(v[1]);
        }
        for (auto &[k, v] : m) {
            ret += 2;
            bool left = true, right = true;
            for (auto &x : v) {
                if (x > 2 && x < 7) {
                    left = false;
                }
                if (x > 6 && x < 9) {
                    right = false;
                }
            }
            if (left && right) {
                ret++;
            } else if (left || right) {
                ret += 0.5;
            }
        }
        return ret + (n - m.size()) * 2;
    }
};