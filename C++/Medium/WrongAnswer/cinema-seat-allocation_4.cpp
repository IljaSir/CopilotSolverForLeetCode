class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        int result = 2 * n;
        unordered_map<int, int> map;
        for (auto& seat : reservedSeats) {
            map[seat[0]] |= 1 << seat[1];
        }
        for (auto& pair : map) {
            int mask = pair.second;
            if ((mask & 0b1111111100) == 0) {
                result -= 2;
            } else if ((mask & 0b11111100) == 0) {
                result -= 1;
            } else if ((mask & 0b111100) == 0) {
                result -= 1;
            } else if ((mask & 0b1111000000) == 0) {
                result -= 1;
            }
        }
        return result;
    }
};