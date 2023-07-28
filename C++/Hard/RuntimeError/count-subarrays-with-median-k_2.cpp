class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(n+1, 0);
        int ans = 0;
        int sum = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; i++) {
            sum += nums[i] < k ? -1 : 1;
            ans += cnt[sum];
            cnt[sum] += 1;
        }
        return ans;
    }
};