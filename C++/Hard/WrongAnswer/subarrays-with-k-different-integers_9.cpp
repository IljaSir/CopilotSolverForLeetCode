class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        int j = 0;
        int i = 0;
        int count = 0;
        unordered_map<int, int> mp;
        for (int j = 0; j < n; j++) {
            if (mp[nums[j]] == 0) {
                count++;
            }
            mp[nums[j]]++;
            while (count > k) {
                mp[nums[i]]--;
                if (mp[nums[i]] == 0) {
                    count--;
                }
                i++;
            }
            int idx = i;
            while (mp[nums[idx]] > 1) {
                mp[nums[idx]]--;
                idx++;
            }
            ans += idx - i + 1;
        }
        return ans;
    }
};