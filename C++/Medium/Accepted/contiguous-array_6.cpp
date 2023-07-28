class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        unordered_map<int, int> mp;
        int n = nums.size(), sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (sum == 0) res = i + 1;
            if (mp.find(sum) != mp.end()) res = max(res, i - mp[sum]);
            else mp[sum] = i;
        }
        return res;
    }
};