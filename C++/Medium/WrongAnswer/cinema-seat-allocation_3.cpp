class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        vector<int> seats(n, 0);
        for (auto& seat : reservedSeats) {
            int row = seat[0] - 1;
            int col = seat[1] - 1;
            seats[row] |= (1 << col);
        }
        int result = n * 2;
        for (int seat : seats) {
            if (seat & 0x3c) {
                result--;
            }
            if (seat & 0x3c0) {
                result--;
            }
            if (seat & 0x3c00) {
                result--;
            }
            if (seat & 0x3c000) {
                result--;
            }
            if (!(seat & 0x3c) && !(seat & 0x3c0) && !(seat & 0x3c00) && !(seat & 0x3c000)) {
                result++;
            }
        }
        return result;
    }
};