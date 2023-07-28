class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        unordered_map<int, int> mp;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (mp.find(sum) == mp.end()) {
                mp[sum] = i;
            } else {
                if (i - mp[sum] > 1) {
                    return true;
                }
            }
        }
        return false;
    }
};