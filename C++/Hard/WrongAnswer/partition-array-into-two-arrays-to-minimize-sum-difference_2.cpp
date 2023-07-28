class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 2;
        vector<int> sum1(1 << n);
        vector<int> sum2(1 << n);
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    sum1[i] += nums[j];
                } else {
                    sum2[i] += nums[j];
                }
            }
        }
        sort(sum1.begin(), sum1.end());
        sort(sum2.begin(), sum2.end());
        int ans = INT_MAX;
        for (int i = 0; i < (1 << n); i++) {
            int target = -sum2[i];
            auto lb = lower_bound(sum1.begin(), sum1.end(), target);
            if (lb != sum1.end()) {
                ans = min(ans, abs(sum2[i] + *lb));
            }
            if (lb != sum1.begin()) {
                ans = min(ans, abs(sum2[i] + *prev(lb)));
            }
        }
        return ans;
    }
};