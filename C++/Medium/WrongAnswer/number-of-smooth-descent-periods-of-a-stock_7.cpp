class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long long total = 0;
        int n = prices.size();
        int count = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] == prices[i - 1] - 1) {
                count++;
            } else {
                total += (count + 1) * count / 2;
                count = 0;
            }
        }
        total += (count + 1) * count / 2;
        return total;
    }
    int numberOfSmoothDescentPeriods(vector<int>& prices) {
        int n = prices.size();
        int count = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] == prices[i - 1] - 1) {
                count++;
            } else {
                count = 0;
            }
        }
        return count;
    }
    int numberOfSmoothDescentPeriods1(vector<int>& prices) {
        int n = prices.size();
        int count = 0;
        int total = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] == prices[i - 1] - 1) {
                count++;
            } else {
                total += count;
                count = 0;
            }
        }
        total += count;
        return total;
    }
};