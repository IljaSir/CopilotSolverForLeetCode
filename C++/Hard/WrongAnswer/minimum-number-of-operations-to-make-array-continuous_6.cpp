class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int res = n;
        for(int i = 0; i < n; ++i){
            int j = upper_bound(nums.begin(), nums.end(), nums[i] + n - 1) - nums.begin();
            res = min(res, n - (j - i));
        }
        return res;
    }
};