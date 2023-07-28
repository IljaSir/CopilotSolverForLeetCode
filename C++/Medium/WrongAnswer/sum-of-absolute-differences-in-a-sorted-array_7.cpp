class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            res.push_back((nums[i] * i - left) + (sum - left - nums[i] * (n - i - 1)));
            left += nums[i];
        }
        return res;
    }
};