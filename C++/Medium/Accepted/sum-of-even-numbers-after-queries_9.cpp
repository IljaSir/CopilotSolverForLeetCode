class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        
        int sum = 0;
        for (auto n : nums) {
            if (n % 2 == 0) {
                sum += n;
            }
        }
        vector<int> ans;
        for (auto query : queries) {
            int val = query[0];
            int index = query[1];
            if (nums[index] % 2 == 0) {
                sum -= nums[index];
            }
            nums[index] += val;
            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }
            ans.push_back(sum);
        }
        return ans;
    }
};