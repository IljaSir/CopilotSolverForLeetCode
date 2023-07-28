class Solution {
public:
    double soupServings(int n) {
        
        if (n > 4800) return 1.0;
        vector<vector<double>> dp(200, vector<double>(200, -1));
        return helper((n + 24) / 25, (n + 24) / 25, dp);
    }
};