class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        sort(reservedSeats.begin(), reservedSeats.end());
        int res = 2 * n;
        int prev = 0;
        for (int i = 0; i < reservedSeats.size(); i++) {
            if (reservedSeats[i][0] != prev) {
                prev = reservedSeats[i][0];
                res -= 2;
            }
            if (reservedSeats[i][1] >= 2 && reservedSeats[i][1] <= 5) {
                res++;
                break;
            }
        }
        for (int i = 0; i < reservedSeats.size(); i++) {
            if (reservedSeats[i][0] != prev) {
                prev = reservedSeats[i][0];
                res -= 2;
            }
            if (reservedSeats[i][1] >= 4 && reservedSeats[i][1] <= 7) {
                res++;
                break;
            }
        }
        for (int i = 0; i < reservedSeats.size(); i++) {
            if (reservedSeats[i][0] != prev) {
                prev = reservedSeats[i][0];
                res -= 2;
            }
            if (reservedSeats[i][1] >= 6 && reservedSeats[i][1] <= 9) {
                res++;
                break;
            }
        }
        return res;
    }
};