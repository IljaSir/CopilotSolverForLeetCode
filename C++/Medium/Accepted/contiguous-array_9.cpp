class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return 0;
        unordered_map<int, int> mp;
        int res = 0;
        int sum = 0;
        mp[0] = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            if (mp.find(sum) != mp.end()) {
                res = max(res, i - mp[sum]);
            } else {
                mp[sum] = i;
            }
        }
        return res;
    }
};