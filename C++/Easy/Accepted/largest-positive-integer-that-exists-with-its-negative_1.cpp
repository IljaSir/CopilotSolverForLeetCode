class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int n = nums.size();
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            mp[nums[i]]++;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                if (mp.count(-nums[i])) {
                    ans = max(ans, nums[i]);
                }
            }
        }
        return ans;
    }
};