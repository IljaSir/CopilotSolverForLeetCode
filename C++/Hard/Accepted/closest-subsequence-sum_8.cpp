class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        int m = n/2;
        n -= m;
        vector<int> sum1(1<<n);
        vector<int> sum2(1<<m);
        for(int i = 0; i < (1<<n); i++) {
            for(int j = 0; j < n; j++) {
                if(i & (1<<j)) {
                    sum1[i] += nums[j];
                }
            }
        }
        for(int i = 0; i < (1<<m); i++) {
            for(int j = 0; j < m; j++) {
                if(i & (1<<j)) {
                    sum2[i] += nums[j+n];
                }
            }
        }
        sort(sum2.begin(), sum2.end());
        int ans = INT_MAX;
        for(int i = 0; i < (1<<n); i++) {
            int val = goal - sum1[i];
            int idx = lower_bound(sum2.begin(), sum2.end(), val) - sum2.begin();
            if(idx < (1<<m)) {
                ans = min(ans, abs(val - sum2[idx]));
            }
            if(idx > 0) {
                ans = min(ans, abs(val - sum2[idx-1]));
            }
        }
        return ans;
    }
};