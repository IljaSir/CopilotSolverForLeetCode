class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long long res = 0;
        int n = prices.size();
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j < n && prices[j] - prices[j - 1] == 1) {
                j++;
            }
            if (j > i) {
                res += (j - i + 1) * (j - i) / 2;
                i = j - 1;
            }
        }
        return res;
    }
    int numberOfSmoothDescentPeriods(vector<int>& prices) {
        int n = prices.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && prices[j] - prices[j - 1] == 1) {
                j++;
            }
            if (j > i) {
                res += (j - i + 1) * (j - i) / 2;
                i = j - 1;
            }
        }
        return res;
    }
};