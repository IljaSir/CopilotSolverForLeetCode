class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        sort(nums.begin(), nums.end(), greater<int>());
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        int sum2 = 0;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            sum2 += nums[i];
            res.push_back(nums[i]);
            if (sum2 > sum - sum2) {
                break;
            }
        }
        return res;
    }
};