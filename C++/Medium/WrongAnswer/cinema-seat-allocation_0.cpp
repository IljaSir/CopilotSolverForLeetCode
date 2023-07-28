class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        int res = 0;
        unordered_map<int, int> m;
        for (auto& r : reservedSeats) {
            m[r[0]] |= 1 << (r[1] - 1);
        }
        for (auto& [k, v] : m) {
            int cnt = 0;
            if ((v & 0b1111000000) == 0) {
                ++cnt;
            }
            if ((v & 0b111100) == 0) {
                ++cnt;
            }
            if ((v & 0b11110000) == 0) {
                ++cnt;
            }
            res += cnt;
        }
        res += (n - m.size()) * 2;
        return res;
    }
};