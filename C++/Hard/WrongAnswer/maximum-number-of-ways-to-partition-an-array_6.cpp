class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        int ans = 0;
        int lsum = 0;
        for (int i = 0; i < n; ++i) {
            if (lsum == sum - lsum - nums[i]) {
                ans++;
            }
            lsum += nums[i];
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == k) {
                cnt++;
            }
        }
        if (cnt == 0) {
            for (int i = 0; i < n; ++i) {
                int old = nums[i];
                nums[i] = k;
                int lsum = 0;
                for (int j = 0; j < n; ++j) {
                    if (lsum == sum - lsum - nums[j]) {
                        ans = max(ans, 1);
                    }
                    lsum += nums[j];
                }
                nums[i] = old;
            }
        } else {
            ans = max(ans, 1);
        }
        return ans;
    }
};