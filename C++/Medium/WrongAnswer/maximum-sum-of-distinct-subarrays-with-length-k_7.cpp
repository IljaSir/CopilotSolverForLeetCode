class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();
        int l = 0;
        int r = 0;
        long long sum = 0;
        long long ans = 0;
        unordered_map<int, int> mp;
        while(r < n) {
            if(mp[nums[r]] == 0) {
                sum += nums[r];
            }
            mp[nums[r]]++;
            if(r - l + 1 == k) {
                ans = max(ans, sum);
                if(mp[nums[l]] == 1) {
                    sum -= nums[l];
                }
                mp[nums[l]]--;
                l++;
            }
            r++;
        }
        return ans;
    }
};