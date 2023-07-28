class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        sort(price.begin(), price.end());
        int n = price.size();
        int sum = accumulate(price.begin(), price.begin() + k, 0);
        int minSum = sum;
        for (int i = k; i < n; ++i) {
            sum += price[i] - price[i - k];
            minSum = min(minSum, sum);
        }
        return sum - minSum;
    }
};