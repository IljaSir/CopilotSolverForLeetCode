class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        unordered_map<int, int> mp;
        int mod = 1e9+7;
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int r = reverse(nums[i]);
            int d = nums[i] - r;
            if (mp.count(d)) {
                ans = (ans + mp[d]) % mod;
            }
            mp[d]++;
        }
        return ans;
    }
    
    int reverse(int x) {
        int r = 0;
        while (x) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
};