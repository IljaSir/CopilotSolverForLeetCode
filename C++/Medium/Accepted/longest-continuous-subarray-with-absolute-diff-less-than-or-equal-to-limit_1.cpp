class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        
        int n = nums.size();
        int i = 0, j = 0;
        int res = 0;
        multiset<int> s;
        while (j < n) {
            s.insert(nums[j]);
            while (*s.rbegin() - *s.begin() > limit) {
                s.erase(s.find(nums[i]));
                i++;
            }
            res = max(res, j - i + 1);
            j++;
        }
        return res;
    }
};