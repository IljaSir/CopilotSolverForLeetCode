class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0, j = 0, sum = 0, ans = 0;
        unordered_map<int, int> mp;
        while (j < n) {
            mp[nums[j]]++;
            sum += nums[j];
            while (mp[nums[j]] > 1) {
                mp[nums[i]]--;
                sum -= nums[i];
                i++;
            }
            ans = max(ans, sum);
            j++;
        }
        return ans;
    }
};