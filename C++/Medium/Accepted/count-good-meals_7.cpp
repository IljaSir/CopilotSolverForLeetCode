class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        int maxSum = 0;
        for (auto& d : deliciousness) {
            maxSum = max(maxSum, d);
        }
        maxSum *= 2;
        
        unordered_map<int, int> m;
        int ans = 0;
        for (auto& d : deliciousness) {
            int sum = 1;
            while (sum <= maxSum) {
                ans += m[sum - d];
                ans %= 1000000007;
                sum *= 2;
            }
            m[d]++;
        }
        return ans;
    }
};