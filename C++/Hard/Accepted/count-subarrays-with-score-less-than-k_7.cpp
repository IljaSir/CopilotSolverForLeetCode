class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        long long sum = 0;
        int n = nums.size();
        long long ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum * (i - l + 1) >= k) {
                sum -= nums[l++];
            }
            ans += i - l + 1;
        }
        return ans;
    }
};