class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        
        int n = nums.size();
        int l = 0, r = 0;
        int ans = 0;
        multiset<int> s;
        while (r < n) {
            s.insert(nums[r]);
            while (*s.rbegin() - *s.begin() > limit) {
                s.erase(s.find(nums[l]));
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};