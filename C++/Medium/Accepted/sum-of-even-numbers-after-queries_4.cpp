class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        
        int sum = 0;
        vector<int> ret;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                sum += nums[i];
            }
        }
        for (int i = 0; i < queries.size(); i++) {
            if (nums[queries[i][1]] % 2 == 0) {
                sum -= nums[queries[i][1]];
            }
            nums[queries[i][1]] += queries[i][0];
            if (nums[queries[i][1]] % 2 == 0) {
                sum += nums[queries[i][1]];
            }
            ret.push_back(sum);
        }
        return ret;
    }
};