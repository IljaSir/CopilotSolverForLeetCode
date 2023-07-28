class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        
        vector<int> sum;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = i; j < n; j++) {
                s += nums[j];
                sum.push_back(s);
            }
        }
        sort(sum.begin(), sum.end());
        for (int i = left - 1; i < right; i++) {
            ans += sum[i];
            ans %= 1000000007;
        }
        return ans;
    }
};