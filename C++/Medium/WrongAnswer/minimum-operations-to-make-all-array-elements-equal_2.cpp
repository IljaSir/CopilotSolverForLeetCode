class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        vector<long long> res;
        for (int i = 0; i < queries.size(); ++i) {
            int count = 0;
            for (int j = 0; j < nums.size(); ++j) {
                if (nums[j] < queries[i]) {
                    count += queries[i] - nums[j];
                }
            }
            res.push_back(count);
        }
        return res;
    }
};