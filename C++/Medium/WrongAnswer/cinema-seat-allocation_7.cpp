class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        int ans = 0;
        map<int, int> M;
        for (auto &v: reservedSeats) {
            M[v[0]] |= 1 << (v[1] - 1);
        }
        for (auto &v: M) {
            int r = v.second;
            if (r & 0b0001111000) continue;
            if (r & 0b0000000111) {
                if (r & 0b1110000000) continue;
                ans += 1;
            } else {
                ans += 2;
            }
        }
        return ans + 2 * (n - M.size());
    }
};