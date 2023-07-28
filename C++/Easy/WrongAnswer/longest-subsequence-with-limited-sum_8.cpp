class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        vector<int> ans;
        for (int i = 0; i < queries.size(); i++) {
            int currSum = 0;
            int currSize = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (currSum + nums[j] <= queries[i]) {
                    currSum += nums[j];
                    currSize++;
                }
            }
            ans.push_back(currSize);
        }
        return ans;
    }
};