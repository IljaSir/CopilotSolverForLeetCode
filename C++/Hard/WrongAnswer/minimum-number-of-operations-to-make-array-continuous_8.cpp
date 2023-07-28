class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int start = 0, end = 0;
        int res = n;
        while (end < n) {
            while (end < n && nums[end] - nums[start] < n) {
                end++;
            }
            if (end == n) break;
            res = min(res, n - (end - start));
            start++;
        }
        return res;
    }
};