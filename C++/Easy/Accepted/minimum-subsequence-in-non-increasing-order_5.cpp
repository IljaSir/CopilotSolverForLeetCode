class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        vector<int> res;
        int sum = 0;
        for (int i : nums)
            sum += i;
        sort(nums.begin(), nums.end(), greater<int>());
        int tmp = 0;
        for (int i = 0; i < nums.size(); i++) {
            tmp += nums[i];
            res.push_back(nums[i]);
            if (tmp > sum - tmp)
                break;
        }
        return res;
    }
};