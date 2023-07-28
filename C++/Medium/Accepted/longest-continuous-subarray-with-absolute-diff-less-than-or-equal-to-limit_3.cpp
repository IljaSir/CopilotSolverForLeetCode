class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        
        int n = nums.size();
        int res = 0;
        int left = 0, right = 0;
        multiset<int> s;
        while (right < n) {
            s.insert(nums[right]);
            while (*s.rbegin() - *s.begin() > limit) {
                s.erase(s.find(nums[left]));
                left++;
            }
            res = max(res, right - left + 1);
            right++;
        }
        return res;
    }
};