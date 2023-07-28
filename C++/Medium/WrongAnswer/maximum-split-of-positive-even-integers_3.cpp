class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        
        int n = finalSum / 2;
        vector<long long> ans(n);
        for (int i = 0; i < n; i++) {
            ans[i] = 2;
        }
        ans[n - 1] += finalSum % 2;
        return ans;
    }
};