class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        unordered_map<int, int> reserved;
        for (auto& seat : reservedSeats) {
            reserved[seat[0]] |= (1 << (seat[1] - 1));
        }
        int ans = 0;
        for (auto& [row, mask] : reserved) {
            int left = 0b1111000000;
            int mid = 0b111100;
            int right = 0b111100000000;
            if ((mask & left) == 0) {
                ans += 1;
            }
            if ((mask & mid) == 0) {
                ans += 1;
            }
            if ((mask & right) == 0) {
                ans += 1;
            }
        }
        ans += (n - reserved.size()) * 2;
        return ans;
    }
};