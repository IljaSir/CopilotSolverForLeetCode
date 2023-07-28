class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        sort(nums.begin(), nums.end(), greater<int>());
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        vector<int> result = {};
        int temp = 0;
        for (int i = 0; i < nums.size(); i++) {
            temp += nums[i];
            result.push_back(nums[i]);
            if (temp > sum - temp) {
                break;
            }
        }
        return result;
    }
};