class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        map<int, int> mp;
        for (int i = 0; i < n; i++) {
            mp[nums[i]]++;
        }
        for (auto i : mp) {
            if (i.second >= 2) {
                return true;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i + 1] - 1) {
                return true;
            }
        }
        return false;
    }
};