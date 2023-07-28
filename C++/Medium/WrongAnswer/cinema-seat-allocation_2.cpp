class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        unordered_map<int, int> reserved;
        for (auto& v : reservedSeats) {
            reserved[v[0]] |= (1 << (v[1] - 1));
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (reserved.find(i) == reserved.end()) {
                ans += 2;
            } else {
                if (reserved[i] & 0b11111100) {
                    ans += 1;
                }
                if (reserved[i] & 0b00001111) {
                    ans += 1;
                }
                if (reserved[i] & 0b11110000) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
};