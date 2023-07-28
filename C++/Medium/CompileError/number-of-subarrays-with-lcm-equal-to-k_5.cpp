class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        int lcm = 1;
        for (int i = 0; i < n; ++i) {
            lcm = lcm * nums[i] / gcd(lcm, nums[i]);
            if (lcm == k) {
                ++ans;
                lcm = 1;
            }
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 1) {
                ans += subarrayLCM(vector<int>(nums.begin() + i, nums.end()), k);
            }
        }
        return ans;
    }
};