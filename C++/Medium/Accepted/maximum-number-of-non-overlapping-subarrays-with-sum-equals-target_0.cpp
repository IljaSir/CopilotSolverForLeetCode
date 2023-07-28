class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        unordered_map<int, int> mp;
        mp[0] = -1;
        int sum = 0;
        int res = 0;
        int last = -1;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (mp.find(sum - target) != mp.end()) {
                if (mp[sum - target] >= last) {
                    res++;
                    last = i;
                }
            }
            mp[sum] = i;
        }
        return res;
    }
};