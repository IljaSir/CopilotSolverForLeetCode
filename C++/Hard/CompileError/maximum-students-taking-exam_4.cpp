class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size(), n = seats[0].size();
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < m; i++) {
            vector<int> next(1 << n, 0);
            for (int j = 0; j < (1 << n); j++) {
                if (valid(seats[i], j)) {
                    for (int k = 0; k < (1 << n); k++) {
                        if (!(j & k)) {
                            next[j] = max(next[j], dp[k] + __builtin_popcount(j));
                        }
                    }
                }
            }
            dp = next;
        }
        return *max_element(dp.begin(), dp.end());
    }
};