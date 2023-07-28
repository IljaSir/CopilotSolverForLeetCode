class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n < 2) return false;
        if (k == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) return true;
            }
            return false;
        }
        unordered_map<int, int> mp;
        mp[0] = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= k;
            if (mp.count(sum)) {
                if (i - mp[sum] >= 2) return true;
            } else {
                mp[sum] = i;
            }
        }
        return false;
    }
};