class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int k = (nums[n/2] - nums[n/2-1])/2;
        vector<int> res;
        for (int i = 0; i < n; i += 2) {
            res.push_back(nums[i] - k);
        }
        return res;
    }
};