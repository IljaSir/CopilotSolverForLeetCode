class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long long n = prices.size();
        long long ans = 0;
        long long i = 0;
        while(i < n) {
            long long j = i + 1;
            long long count = 0;
            while(j < n and prices[j] == prices[j - 1] - 1) {
                count++;
                j++;
            }
            ans += (count * (count + 1)) / 2;
            i = j;
        }
        return ans;
    }
    int numberOfSmoothDescentPeriods(vector<int>& prices) {
        long long n = prices.size();
        long long ans = 0;
        long long i = 0;
        while(i < n) {
            long long j = i + 1;
            long long count = 0;
            while(j < n and prices[j] == prices[j - 1] - 1) {
                count++;
                j++;
            }
            ans += getDescentPeriods(prices) - ((count * (count + 1)) / 2);
            i = j;
        }
        return ans;
    }
};