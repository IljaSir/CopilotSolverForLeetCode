class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        int n = nums.size();
        int m = n/3;
        sort(nums.begin(), nums.end());
        long long ans = 1e18;
        for(int i = 0; i < m; i++){
            ans = min(ans, (long long)nums[n-1-i] - nums[i]);
            ans = min(ans, (long long)nums[n-1-i] - nums[i+m]);
        }
        return ans;
    }
};