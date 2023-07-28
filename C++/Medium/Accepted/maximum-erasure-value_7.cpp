class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        unordered_map<int, int> mp;
        while (j < n) {
            if (mp.find(nums[j]) == mp.end()) {
                mp[nums[j]] = j;
                sum += nums[j];
                ans = max(ans, sum);
                j++;
            } else {
                int k = mp[nums[j]];
                while (i <= k) {
                    sum -= nums[i];
                    mp.erase(nums[i]);
                    i++;
                }
            }
        }
        return ans;
    }
};