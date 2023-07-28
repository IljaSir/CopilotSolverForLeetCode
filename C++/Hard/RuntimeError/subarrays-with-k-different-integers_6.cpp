class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        int left = 0, right = 0;
        unordered_map<int, int> mp;
        while (right < n) {
            mp[nums[right]]++;
            while (mp.size() > k) {
                mp[nums[left]]--;
                if (mp[nums[left]] == 0) {
                    mp.erase(nums[left]);
                }
                left++;
            }
            int tmp = left;
            while (mp.size() == k) {
                mp[nums[tmp]]--;
                if (mp[nums[tmp]] == 0) {
                    mp.erase(nums[tmp]);
                }
                tmp++;
                ans++;
            }
            while (left < tmp) {
                mp[nums[left]]++;
                left++;
            }
            right++;
        }
        return ans;
    }
};