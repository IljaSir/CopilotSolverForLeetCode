class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        unordered_map<int, int> mp;
        mp[0] = -1;
        int sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mp.count(sum - target)) {
                res++;
                mp.clear();
                mp[0] = i;
            }
            else
                mp[sum] = i;
        }
        return res;
    }
};