class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        
        int ans = 0;
        int m = reservedSeats.size();
        sort(reservedSeats.begin(), reservedSeats.end());
        int i = 0;
        while(i < m) {
            int j = i;
            while(j < m && reservedSeats[j][0] == reservedSeats[i][0]) j++;
            int cnt = 0;
            for(int k = i; k < j; k++) {
                if(reservedSeats[k][1] >= 2 && reservedSeats[k][1] <= 5) {
                    cnt |= 1;
                }
                if(reservedSeats[k][1] >= 6 && reservedSeats[k][1] <= 9) {
                    cnt |= 2;
                }
            }
            if(cnt == 0) {
                ans += 2;
            } else if(cnt == 1 || cnt == 2) {
                ans += 1;
            }
            i = j;
        }
        return ans + (n - reservedSeats.size()) * 2;
    }
};