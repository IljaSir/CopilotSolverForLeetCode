class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        vector<int> sum(nums.size() + 1, 0);
        for (int i = 0; i < nums.size(); i++) {
            sum[i + 1] = sum[i] + nums[i] % 2;
        }
        long long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j <= nums.size(); j++) {
                if ((sum[j] - sum[i]) % 2 == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
};